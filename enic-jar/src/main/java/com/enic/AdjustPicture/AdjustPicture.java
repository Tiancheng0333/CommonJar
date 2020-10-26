package com.enic.AdjustPicture;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.*;

public class AdjustPicture {

    final static String dir = "/Users/test";//文件所在路径

    public static void main(String[] args) throws IOException {
        recursiveTraversalFolder(dir);//递归遍历此路径下所有文件夹
    }

    /**
     * 递归遍历文件夹获取文件
     */
    public static void recursiveTraversalFolder(String path) throws IOException {
        File folder = new File(path);
        if (folder.exists()) {
            File[] fileArr = folder.listFiles();
            if (null == fileArr || fileArr.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                File newDir = null;//文件所在文件夹路径+新文件名
                String newName = "";//新文件名
                String fileName = null;//旧文件名
                File parentPath = new File("");//文件所在父级路径
                for (File file : fileArr) {
                    if (file.isDirectory()) {//是文件夹，继续递归，如果需要重命名文件夹，这里可以做处理
                        System.out.println("文件夹:" + file.getAbsolutePath() + "，继续递归！");
                        recursiveTraversalFolder(file.getAbsolutePath());
                    } else {
                        String fileNameNow = file.getName();
                        if (fileNameNow.contains(".jpg") || fileNameNow.contains(".png")) {
                            System.out.println(fileNameNow);
                            BufferedImage bufferedImage = ImageIO.read(file);
                            InputStream inputStream = rotateImg(bufferedImage, 180, Color.BLACK);
                            int index;
                            byte[] bytes = new byte[1024];
                            FileOutputStream downloadFile = new FileOutputStream("/Users/test/" + System.currentTimeMillis() + ".jpg");
                            while ((index = inputStream.read(bytes)) != -1) {
                                downloadFile.write(bytes, 0, index);
                                downloadFile.flush();
                            }
                            inputStream.close();
                            downloadFile.close();
                        }

                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }

    /**
     * 旋转图片
     *
     * @param image
     * @param degree
     * @param bgcolor
     * @return
     * @throws IOException
     */
    private static InputStream rotateImg(BufferedImage image, int degree, Color bgcolor) throws IOException {
        int iw = image.getWidth();//原始图象的宽度
        int ih = image.getHeight();//原始图象的高度
        int w = 0;
        int h = 0;
        int x = 0;
        int y = 0;
        degree = degree % 360;
        if (degree < 0)
            degree = 360 + degree;//将角度转换到0-360度之间
        double ang = Math.toRadians(degree);//将角度转为弧度

        /**
         *确定旋转后的图象的高度和宽度
         */

        if (degree == 180 || degree == 0 || degree == 360) {
            w = iw;
            h = ih;
        } else if (degree == 90 || degree == 270) {
            w = ih;
            h = iw;
        } else {
            int d = iw + ih;
            w = (int) (d * Math.abs(Math.cos(ang)));
            h = (int) (d * Math.abs(Math.sin(ang)));
        }

        x = (w / 2) - (iw / 2);//确定原点坐标
        y = (h / 2) - (ih / 2);
        BufferedImage rotatedImage = new BufferedImage(w, h, image.getType());
        Graphics2D gs = (Graphics2D) rotatedImage.getGraphics();
        if (bgcolor == null) {
            rotatedImage = gs.getDeviceConfiguration().createCompatibleImage(w, h, Transparency.TRANSLUCENT);
        } else {
            gs.setColor(bgcolor);
            gs.fillRect(0, 0, w, h);//以给定颜色绘制旋转后图片的背景
        }

        AffineTransform at = new AffineTransform();
        at.rotate(ang, w / 2, h / 2);//旋转图象
        at.translate(x, y);
        AffineTransformOp op = new AffineTransformOp(at, AffineTransformOp.TYPE_BICUBIC);
        op.filter(image, rotatedImage);
        image = rotatedImage;

        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ImageOutputStream imageOut = ImageIO.createImageOutputStream(byteOut);
        ImageIO.write(image, "png", imageOut);
        return new ByteArrayInputStream(byteOut.toByteArray());
    }
}

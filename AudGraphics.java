// =================================
// DO NOT MODIFY THIS CLASS
// =================================
// This class is necessary as we can't allow access to AWT directly
// When testing submissions on EST this class will be replaced by a class that does not need AWT
public class AudGraphics {
	private java.awt.Graphics2D g2d;
	
    public AudGraphics(java.awt.Graphics2D g2d) {
    	this.g2d = g2d;
    }

    public void draw3DRect(int x, int y, int width, int height,
                           boolean raised) {
    	this.g2d.draw3DRect(x, y, width, height, raised);
    }

    public void fill3DRect(int x, int y, int width, int height,
                           boolean raised) {
        this.g2d.fill3DRect(x, y, width, height, raised);
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
    	this.g2d.drawLine(x1, y1, x2, y2);
    }


    public void fillRect(int x, int y, int width, int height) {
    	this.g2d.fillRect(x, y, width, height);
    }

    public void drawRect(int x, int y, int width, int height) {
        this.g2d.drawRect(x, y, width, height);
    }

    public void clearRect(int x, int y, int width, int height) {
    	this.g2d.fillRect(x, y, width, height);
    }

    public void drawRoundRect(int x, int y, int width, int height,
                                       int arcWidth, int arcHeight) {
    	this.g2d.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
    }

    public void fillRoundRect(int x, int y, int width, int height,
                                       int arcWidth, int arcHeight) {
    	this.g2d.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
    }

    public void drawOval(int x, int y, int width, int height) {
    	this.g2d.drawOval(x, y, width, height);
    }

    public void fillOval(int x, int y, int width, int height) {
    	this.g2d.fillOval(x, y, width, height);
    }

    public void drawArc(int x, int y, int width, int height,
                                 int startAngle, int arcAngle) {
    	this.g2d.drawArc(x, y, width, height, startAngle, arcAngle);
    }

    public void fillArc(int x, int y, int width, int height,
                                 int startAngle, int arcAngle) {
    	this.g2d.fillArc(x, y, width, height, startAngle, arcAngle);
    }

    public void drawPolyline(int xPoints[], int yPoints[],
                                      int nPoints) {
    	this.g2d.drawPolyline(xPoints, yPoints, nPoints);
    }

    public void drawPolygon(int xPoints[], int yPoints[],
                                     int nPoints) {
    	this.g2d.drawPolygon(xPoints, yPoints, nPoints);
    }

    public void fillPolygon(int xPoints[], int yPoints[],
                                     int nPoints) {
    	this.g2d.fillPolygon(xPoints, yPoints, nPoints);
    }

    public void drawString(String str, int x, int y) {
    	this.g2d.drawString(str, x, y);
    }

    public AudColor getColor() {
    	return new AudColor(this.g2d.getColor().getRGB());
    }

    public void setColor(AudColor c) {
    	this.g2d.setColor(new java.awt.Color(c.getRGB()));
    }
    
    public void setBackground(AudColor color) {
    	this.g2d.setBackground(new java.awt.Color(color.getRGB()));
    }

    public AudColor getBackground() {
    	return new AudColor(this.g2d.getBackground().getRGB());
    }

//    public void setStroke(Stroke s) {
//    	this.g2d.setStroke(s);
//    }
//    
//    public Stroke getStroke() {
//    	return this.g2d.getStroke();
//    }
}


//这个Java类名为AudGraphics，作为java.awt.Graphics2D类的包装器或接口，提供了一组图形绘制操作的子集。该类的目的是封装某些图形功能，允许有限度地访问，而不直接暴露底层的AWT（Abstract Window Toolkit）图形功能。

// 以下是该类及其方法的详细说明：

// 构造方法：
// public AudGraphics(java.awt.Graphics2D g2d)：使用对java.awt.Graphics2D对象的引用初始化AudGraphics的实例。
// 绘图操作：
// 诸如draw3DRect、fill3DRect、drawLine、fillRect、drawRect、clearRect、drawRoundRect、fillRoundRect、drawOval、fillOval、drawArc、fillArc、drawPolyline、drawPolygon和fillPolygon等方法用于绘制各种形状和线条。
// 文本绘制：
// public void drawString(String str, int x, int y)：在指定的坐标处绘制指定的字符串。
// 颜色管理：
// public AudColor getColor()：获取当前绘图颜色。
// public void setColor(AudColor c)：根据AudColor对象设置绘图颜色。
// public void setBackground(AudColor color)：设置背景颜色。
// public AudColor getBackground()：获取当前背景颜色。
// 颜色类：
// 该类似乎使用另一个名为AudColor的类来表示颜色。虽然在代码片段中没有提供此类的信息，但它可能封装了颜色信息。
// 注释：
// 代码中有关于设置和获取画笔的代码被注释掉。这些代码可能被注释掉是有原因的，可能是因为功能没有完全实现或被认为是不必要的。
// 总的来说，AudGraphics充当了AWT Graphics2D类的包装器，提供了一组绘图操作和颜色管理功能。它允许有限度地访问图形功能，并可作为一个更大系统的一部分，在其中直接访问AWT被限制或出于特定原因（如测试或安全性）被替换。
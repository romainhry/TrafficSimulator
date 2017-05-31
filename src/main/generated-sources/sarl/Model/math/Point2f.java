package model.math;

import io.sarl.lang.annotation.SarlSpecification;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.5")
@SuppressWarnings("all")
public class Point2f {
  private float x;
  
  private float y;
  
  public Point2f(final float i, final float j) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Pure
  public float distanceSquared(final Point2f p1) {
    float dx = 0;
    float dy = 0;
    dx = (this.x - p1.x);
    dy = (this.y - p1.y);
    return ((dx * dx) + (dy * dy));
  }
  
  public Point2f add(final Point2f p1) {
    return new Point2f((this.x + p1.x), (this.y + p1.y));
  }
  
  @Pure
  public float getX() {
    return this.x;
  }
  
  @Pure
  public float getY() {
    return this.y;
  }
  
  /**
   * Computes the distance between this point and point p1.
   * @param p1 the other point
   * @return the distance.
   */
  @Pure
  public float distance(final Point2f p1) {
    float dx = 0;
    float dy = 0;
    dx = (this.x - p1.x);
    dy = (this.y - p1.y);
    double _sqrt = Math.sqrt(((dx * dx) + (dy * dy)));
    return ((float) _sqrt);
  }
  
  /**
   * Computes the L-1 (Manhattan) distance between this point and
   * point p1.  The L-1 distance is equal to abs(x1-x2) + abs(y1-y2).
   * @param p1 the other point
   * @return the distance.
   */
  @Pure
  public float distanceL1(final Point2f p1) {
    float _abs = Math.abs((this.x - p1.x));
    float _abs_1 = Math.abs((this.y - p1.y));
    return (_abs + _abs_1);
  }
  
  /**
   * Computes the L-infinite distance between this point and
   * point p1.  The L-infinite distance is equal to
   * MAX[abs(x1-x2), abs(y1-y2)].
   * @param p1 the other point
   * @return the distance.
   */
  @Pure
  public float distanceLinf(final Point2f p1) {
    return Math.max(Math.abs((this.x - p1.x)), Math.abs((this.y - p1.y)));
  }
}

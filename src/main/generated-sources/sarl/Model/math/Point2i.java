package model.math;

import io.sarl.lang.annotation.SarlSpecification;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.5")
@SuppressWarnings("all")
public class Point2i {
  private int x;
  
  private int y;
  
  public Point2i(final int i, final int j) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Pure
  public float distanceSquared(final Point2i p1) {
    float dx = 0;
    float dy = 0;
    dx = (this.x - p1.x);
    dy = (this.y - p1.y);
    return ((dx * dx) + (dy * dy));
  }
  
  @Pure
  public int getX() {
    return this.x;
  }
  
  @Pure
  public int getY() {
    return this.y;
  }
  
  /**
   * Computes the distance between this point and point p1.
   * @param p1 the other point
   * @return the distance.
   */
  @Pure
  public float distance(final Point2i p1) {
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
  public float distanceL1(final Point2i p1) {
    int _abs = Math.abs((this.x - p1.x));
    int _abs_1 = Math.abs((this.y - p1.y));
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
  public float distanceLinf(final Point2i p1) {
    return Math.max(Math.abs((this.x - p1.x)), Math.abs((this.y - p1.y)));
  }
}

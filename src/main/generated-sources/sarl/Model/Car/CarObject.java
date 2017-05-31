package model.Car;

import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import model.EnvObjects;
import model.Graph;
import model.math.Point2i;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.5")
@SuppressWarnings("all")
public abstract class CarObject implements Serializable {
  private final Point2i position;
  
  private final transient WeakReference<EnvObjects> road;
  
  public CarObject(final int x, final int y, final Graph road) {
    Point2i _point2i = new Point2i(x, y);
    this.position = _point2i;
    WeakReference _weakReference = new WeakReference(road);
    this.road = _weakReference;
  }
  
  public CarObject(final Point2i position, final Graph road) {
    this(position.getX(), position.getY(), road);
  }
  
  @Pure
  public Point2i getPosition() {
    return this.position;
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 461457153L;
}

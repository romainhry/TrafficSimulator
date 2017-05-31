package model;

import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import model.EnvObjects;
import model.math.Point2f;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.5")
@SuppressWarnings("all")
public class PositionedObjects extends EnvObjects {
  private Point2f position;
  
  private Point2f influence;
  
  private int turnTo = 0;
  
  @Pure
  public Point2f getPosition() {
    return this.position;
  }
  
  @Pure
  public Point2f getInfluence() {
    return this.influence;
  }
  
  public Point2f setPosition(final Point2f pos) {
    return this.position = pos;
  }
  
  @Pure
  public int getTurnTo() {
    return this.turnTo;
  }
  
  public int setTurnTo(final int b) {
    return this.turnTo = b;
  }
  
  @SyntheticMember
  public PositionedObjects() {
    super();
  }
}

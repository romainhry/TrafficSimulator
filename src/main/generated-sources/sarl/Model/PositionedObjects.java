package model;

import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import model.EnvObjects;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.5")
@SuppressWarnings("all")
public class PositionedObjects extends EnvObjects {
  private float position;
  
  @Pure
  public float getPosition() {
    return this.position;
  }
  
  @SyntheticMember
  public PositionedObjects() {
    super();
  }
}

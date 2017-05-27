package model;

import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.5")
@SuppressWarnings("all")
public class EnvObjects {
  private float length;
  
  @Pure
  public float getLength() {
    return this.length;
  }
  
  @SyntheticMember
  public EnvObjects() {
    super();
  }
}

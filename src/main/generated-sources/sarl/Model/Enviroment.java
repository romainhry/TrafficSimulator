package model;

import io.sarl.core.Initialize;
import io.sarl.lang.annotation.PerceptGuardEvaluator;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.BuiltinCapacitiesProvider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;
import javax.inject.Inject;
import model.Car.AgentBody;
import model.Car.TimeStep;
import model.Graph;
import model.GraphNode;
import model.PositionedObjects;
import model.math.Point2f;
import model.road.PositionOnTheGraph;

@SarlSpecification("0.5")
@SuppressWarnings("all")
public class Enviroment extends Agent {
  private Collection<AgentBody> bodies;
  
  private Graph graph = new Graph();
  
  @SyntheticMember
  private void $behaviorUnit$Initialize$0(final Initialize occurrence) {
  }
  
  @SyntheticMember
  private void $behaviorUnit$TimeStep$1(final TimeStep occurrence) {
    this.percieve();
    this.applyInfluences();
  }
  
  protected TreeMap<AgentBody, List<PositionedObjects>> percieve() {
    TreeMap<AgentBody, List<PositionedObjects>> map = new TreeMap<AgentBody, List<PositionedObjects>>();
    float i = 0;
    float j = 0;
    ArrayList<GraphNode> _nodes = this.graph.getNodes();
    for (final GraphNode gn : _nodes) {
      ArrayList<PositionedObjects> _posObj = gn.getPosObj();
      for (final PositionedObjects o : _posObj) {
        {
          List<PositionedObjects> li = null;
          if ((o instanceof AgentBody)) {
            for (i = (((AgentBody)o).getLength() + 1); (i < ((AgentBody)o).getFrustum()); i++) {
              float _x = ((AgentBody)o).getPosition().getX();
              float _plus = (i + _x);
              float _length = gn.getLength();
              boolean _lessEqualsThan = (_plus <= _length);
              if (_lessEqualsThan) {
                float _x_1 = ((AgentBody)o).getPosition().getX();
                float _plus_1 = (i + _x_1);
                Boolean _isEmptyAt = gn.isEmptyAt(_plus_1, 0);
                boolean _not = (!(_isEmptyAt).booleanValue());
                if (_not) {
                  float _x_2 = ((AgentBody)o).getPosition().getX();
                  float _plus_2 = (i + _x_2);
                  PositionedObjects _objectAt = gn.objectAt(_plus_2);
                  li.add(_objectAt);
                  break;
                }
              } else {
                ArrayList<GraphNode> _frontNeighbourNodes = gn.getFrontNeighbourNodes();
                for (final GraphNode fnn : _frontNeighbourNodes) {
                  for (j = 0; (j < (((AgentBody)o).getFrustum() - i)); j++) {
                    Boolean _isEmptyAt_1 = fnn.isEmptyAt(j, 0);
                    boolean _not_1 = (!(_isEmptyAt_1).booleanValue());
                    if (_not_1) {
                      PositionedObjects _objectAt_1 = fnn.objectAt(j);
                      li.add(_objectAt_1);
                      break;
                    }
                  }
                }
              }
            }
            for (i = (((AgentBody)o).getLength() + 1); (i < ((AgentBody)o).getFrustum()); i++) {
              float _x = ((AgentBody)o).getPosition().getX();
              float _minus = (_x - i);
              boolean _greaterEqualsThan = (_minus >= 0);
              if (_greaterEqualsThan) {
                float _x_1 = ((AgentBody)o).getPosition().getX();
                float _minus_1 = (_x_1 - i);
                Boolean _isEmptyAt = gn.isEmptyAt(_minus_1, 0);
                boolean _not = (!(_isEmptyAt).booleanValue());
                if (_not) {
                  float _x_2 = ((AgentBody)o).getPosition().getX();
                  float _minus_2 = (_x_2 - i);
                  PositionedObjects _objectAt = gn.objectAt(_minus_2);
                  li.add(_objectAt);
                  break;
                } else {
                  ArrayList<GraphNode> _backNeighbourNodes = gn.getBackNeighbourNodes();
                  for (final GraphNode bnn : _backNeighbourNodes) {
                    for (j = bnn.getLength(); (j < (((AgentBody)o).getFrustum() - i)); j++) {
                      Boolean _isEmptyAt_1 = bnn.isEmptyAt(j, 0);
                      boolean _not_1 = (!(_isEmptyAt_1).booleanValue());
                      if (_not_1) {
                        PositionedObjects _objectAt_1 = bnn.objectAt(j);
                        li.add(_objectAt_1);
                        break;
                      }
                    }
                  }
                }
              }
            }
            map.put(((AgentBody)o), li);
          }
        }
      }
    }
    return map;
  }
  
  protected void applyInfluences() {
    ArrayList<GraphNode> _nodes = this.graph.getNodes();
    for (final GraphNode gn : _nodes) {
      ArrayList<PositionedObjects> _posObj = gn.getPosObj();
      for (final PositionedObjects o : _posObj) {
        boolean _collision = this.collision(o, this.desiredPosition(o, gn));
        boolean _not = (!_collision);
        if (_not) {
          o.setPosition(this.desiredPosition(o, gn).getPosition());
        }
      }
    }
  }
  
  protected boolean collision(final PositionedObjects object, final PositionOnTheGraph newPosition) {
    Boolean _isEmptyAt = newPosition.getGraphNode().isEmptyAt(newPosition.getPosition().getX(), object.getLength());
    if ((_isEmptyAt).booleanValue()) {
      return false;
    } else {
      return true;
    }
  }
  
  protected PositionOnTheGraph desiredPosition(final PositionedObjects posObj, final GraphNode currentNode) {
    float _x = posObj.getPosition().getX();
    float _x_1 = posObj.getInfluence().getX();
    float _plus = (_x + _x_1);
    float _length = currentNode.getLength();
    boolean _lessEqualsThan = (_plus <= _length);
    if (_lessEqualsThan) {
      Point2f _add = posObj.getPosition().add(posObj.getInfluence());
      return new PositionOnTheGraph(_add, currentNode);
    } else {
      Point2f _point2f = new Point2f(0f, 0f);
      GraphNode _nextNode = currentNode.nextNode(posObj.getTurnTo());
      return new PositionOnTheGraph(_point2f, _nextNode);
    }
  }
  
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$Initialize(final Initialize occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$Initialize$0(occurrence));
  }
  
  @SyntheticMember
  @PerceptGuardEvaluator
  private void $guardEvaluator$TimeStep(final TimeStep occurrence, final Collection<Runnable> ___SARLlocal_runnableCollection) {
    assert occurrence != null;
    assert ___SARLlocal_runnableCollection != null;
    ___SARLlocal_runnableCollection.add(() -> $behaviorUnit$TimeStep$1(occurrence));
  }
  
  @SyntheticMember
  public Enviroment(final UUID parentID, final UUID agentID) {
    super(parentID, agentID);
  }
  
  @SyntheticMember
  @Inject
  public Enviroment(final BuiltinCapacitiesProvider provider, final UUID parentID, final UUID agentID) {
    super(provider, parentID, agentID);
  }
}

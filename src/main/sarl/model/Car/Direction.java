package model.Car;

//import fr.utbm.info.ia51.framework.math.Vector2i;
public enum Direction {

	NORTH {

		@Override
		public Direction opposite() {
			return SOUTH;
		}

		@Override
		public Direction left() {
			return WEST;
		}

		@Override
		public Direction right() {
			return EAST;
		}
			
		/*@Override
		public Vector2i toVector() {
			return NORTH_VECTOR;
		}	*/	

	},
	
	EAST {

		@Override
		public Direction opposite() {
			return WEST;
		}

		@Override
		public Direction left() {
			return NORTH;
		}

		@Override
		public Direction right() {
			return SOUTH;
		}
			
		/*@Override
		public Vector2i toVector() {
			return EAST_VECTOR;
		}*/		

	},
	
	SOUTH {

		@Override
		public Direction opposite() {
			return NORTH;
		}

		@Override
		public Direction left() {
			return EAST;
		}

		@Override
		public Direction right() {
			return WEST;
		}
		
		/*@Override
		public Vector2i toVector() {
			return SOUTH_VECTOR;
		}	*/	
		
	},
	
	WEST {
		
		@Override
		public Direction opposite() {
			return EAST;
		}

		@Override
		public Direction left() {
			return SOUTH;
		}

		@Override
		public Direction right() {
			return NORTH;
		}
		
		/*@Override
		public Vector2i toVector() {
			return WEST_VECTOR;
		}	*/	
		
	};
	
	/*public static final Vector2i NORTH_VECTOR = new Vector2i(0, -1);
	public static final Vector2i EAST_VECTOR = new Vector2i(1, 0);
	public static final Vector2i SOUTH_VECTOR = new Vector2i(0, 1);
	public static final Vector2i WEST_VECTOR = new Vector2i(-1, 0);*/
	
	public abstract Direction opposite();
	
	public abstract Direction left();

	public abstract Direction right();
	
	/*public abstract Vector2i toVector();*/

	public static Direction random() {
		return values()[(int) (Math.random() * 4)];
	}
	
	/*public static Direction fromVector(Vector2i v) {
		if (v.getX() > 0) {
			return EAST;
		}
		if (v.getX() < 0) {
			return WEST;
		}
		if (v.getY() > 0) {
			return SOUTH;
		}
		return NORTH;
	}*/

}

package monsterHunt;

/**
 * Represents a hunter object that has default values: <br>
 * 3 shots, firing or not, starting location
 * 
 * @author Brian Munro + John Platt
 *
 */
public class Hunter {
	protected int location;
	protected int ammo;
	protected boolean fireWeapon;
	
	/**
	 * Constructor for Hunter object.
	 */
	public Hunter() {
		this.location = 0;
		this.ammo = 3;
		this.fireWeapon = false;
	}

	

}

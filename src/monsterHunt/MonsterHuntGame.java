package monsterHunt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import java.util.ArrayList;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * Game with a hunter following a monster that is wandering the map.<br>
 * Made up of a grid of nodes for hunter and monster to travel through.<br>
 * Hunter starts with 3 shells of ammunition in the top left corner of the map.<br>
 * The game ends if the hunter runs out of shells, the hunter kills the monster<br>
 * or if the monster kills the hunter.
 * 
 * @author Brian Munro + John Platt
 *
 */
public class MonsterHuntGame {

	protected Shell shell;
	private Button btn00, btn01, btn02, btn03, btn04, btn05, btn06, btn07, btn08, btn09;
	private Button btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19;
	private Button btn20, btn21, btn22, btn23, btn24, btn25, btn26, btn27, btn28, btn29;
	private Button btn30, btn31, btn32, btn33, btn34, btn35, btn36, btn37, btn38, btn39;
	private Button btn40, btn41, btn42, btn43, btn44, btn45, btn46, btn47, btn48, btn49;
	private Button btn50, btn51, btn52, btn53, btn54, btn55, btn56, btn57, btn58, btn59;
	private Button btn60, btn61, btn62, btn63, btn64, btn65, btn66, btn67, btn68, btn69;
	private Button btn70, btn71, btn72, btn73, btn74, btn75, btn76, btn77, btn78, btn79;
	private Button btn80, btn81, btn82, btn83, btn84, btn85, btn86, btn87, btn88, btn89;
	private Button btn90, btn91, btn92, btn93, btn94, btn95, btn96, btn97, btn98, btn99;
	private Button btnFireWeapon, btnMonsterCall;
	private In in  = new In("/Resources/map1.txt");
	private Map map = new Map(in);
	private Label lblAmmo1;
	private Label lblAmmo2;
	private Label lblAmmo3;
	private Text txtHunterLocationIn;
	private Hunter hunter = new Hunter();
	private Monster monster = new Monster();
	private boolean gameOver = false;
	private Stack<Integer> locate = new Stack<Integer>();

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
				
		try {
			MonsterHuntGame window = new MonsterHuntGame();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(1056, 722);
		shell.setText("Monster Hunt");
		shell.setLayout(null);
		
		btn00 = new Button(shell, SWT.NONE);
		btn00.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(0);
			}
		});
		btn00.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn00.setBounds(11, 10, 60, 60);
		
		btn01 = new Button(shell, SWT.NONE);
		btn01.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(1);
			}
		});
		btn01.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn01.setBounds(77, 10, 60, 60);
		
		btn02 = new Button(shell, SWT.NONE);
		btn02.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(2);
			}
		});
		btn02.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn02.setBounds(143, 10, 60, 60);
		
		btn03 = new Button(shell, SWT.NONE);
		btn03.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(3);
			}
		});
		btn03.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn03.setBounds(209, 10, 60, 60);
		
		btn04 = new Button(shell, SWT.NONE);
		btn04.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(4);
			}
		});
		btn04.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn04.setBounds(275, 10, 60, 60);
		
		btn05 = new Button(shell, SWT.NONE);
		btn05.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(5);
			}
		});
		btn05.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn05.setBounds(341, 10, 60, 60);
		
		btn06 = new Button(shell, SWT.NONE);
		btn06.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(6);
			}
		});
		btn06.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn06.setBounds(407, 10, 60, 60);
		
		btn07 = new Button(shell, SWT.NONE);
		btn07.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(7);
			}
		});
		btn07.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn07.setBounds(473, 10, 60, 60);
		
		btn08 = new Button(shell, SWT.NONE);
		btn08.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(8);
			}
		});
		btn08.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn08.setBounds(539, 10, 60, 60);
		
		btn09 = new Button(shell, SWT.NONE);
		btn09.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(9);
			}
		});
		btn09.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn09.setBounds(605, 10, 60, 60);
		
		btn10 = new Button(shell, SWT.NONE);
		btn10.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(10);
			}
		});
		btn10.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn10.setBounds(11, 76, 60, 60);
		
		btn11 = new Button(shell, SWT.NONE);
		btn11.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(11);
			}
		});
		btn11.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn11.setBounds(77, 76, 60, 60);
		
		btn12 = new Button(shell, SWT.NONE);
		btn12.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(12);
			}
		});
		btn12.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn12.setBounds(143, 76, 60, 60);
		
		btn13 = new Button(shell, SWT.NONE);
		btn13.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(13);
			}
		});
		btn13.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn13.setBounds(209, 76, 60, 60);
		
		btn14 = new Button(shell, SWT.NONE);
		btn14.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(14);
			}
		});
		btn14.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn14.setBounds(275, 76, 60, 60);
		
		btn15 = new Button(shell, SWT.NONE);
		btn15.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(15);
			}
		});
		btn15.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn15.setBounds(341, 76, 60, 60);
		
		btn16 = new Button(shell, SWT.NONE);
		btn16.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(16);
			}
		});
		btn16.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn16.setBounds(407, 76, 60, 60);
		
		btn17 = new Button(shell, SWT.NONE);
		btn17.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(17);
			}
		});
		btn17.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn17.setBounds(473, 76, 60, 60);
		
		btn18 = new Button(shell, SWT.NONE);
		btn18.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(18);
			}
		});
		btn18.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn18.setBounds(539, 76, 60, 60);
		
		btn19 = new Button(shell, SWT.NONE);
		btn19.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(19);
			}
		});
		btn19.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn19.setBounds(605, 76, 60, 60);
		
		btn20 = new Button(shell, SWT.NONE);
		btn20.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(20);
			}
		});
		btn20.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn20.setBounds(11, 142, 60, 60);
		
		btn21 = new Button(shell, SWT.NONE);
		btn21.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(21);
			}
		});
		btn21.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn21.setBounds(77, 142, 60, 60);
		
		btn22 = new Button(shell, SWT.NONE);
		btn22.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(22);
			}
		});
		btn22.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn22.setBounds(143, 142, 60, 60);
		
		btn23 = new Button(shell, SWT.NONE);
		btn23.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(23);
			}
		});
		btn23.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn23.setBounds(209, 142, 60, 60);
		
		btn24 = new Button(shell, SWT.NONE);
		btn24.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(24);
			}
		});
		btn24.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn24.setBounds(275, 142, 60, 60);
		
		btn25 = new Button(shell, SWT.NONE);
		btn25.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(25);
			}
		});
		btn25.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn25.setBounds(341, 142, 60, 60);
		
		btn26 = new Button(shell, SWT.NONE);
		btn26.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(26);
			}
		});
		btn26.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn26.setBounds(407, 142, 60, 60);
		
		btn27 = new Button(shell, SWT.NONE);
		btn27.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(27);
			}
		});
		btn27.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn27.setBounds(473, 142, 60, 60);
		
		btn28 = new Button(shell, SWT.NONE);
		btn28.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(28);
			}
		});
		btn28.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn28.setBounds(539, 142, 60, 60);
		
		btn29 = new Button(shell, SWT.NONE);
		btn29.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(29);
			}
		});
		btn29.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn29.setBounds(605, 142, 60, 60);
		
		btn30 = new Button(shell, SWT.NONE);
		btn30.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(30);
			}
		});
		btn30.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn30.setBounds(11, 208, 60, 60);
		
		btn31 = new Button(shell, SWT.NONE);
		btn31.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(31);
			}
		});
		btn31.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn31.setBounds(77, 208, 60, 60);
		
		btn32 = new Button(shell, SWT.NONE);
		btn32.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(32);
			}
		});
		btn32.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn32.setBounds(143, 208, 60, 60);
		
		btn33 = new Button(shell, SWT.NONE);
		btn33.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(33);
			}
		});
		btn33.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn33.setBounds(209, 208, 60, 60);
		
		btn34 = new Button(shell, SWT.NONE);
		btn34.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(34);
			}
		});
		btn34.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn34.setBounds(275, 208, 60, 60);
		
		btn35 = new Button(shell, SWT.NONE);
		btn35.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(35);
			}
		});
		btn35.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn35.setBounds(341, 208, 60, 60);
		
		btn36 = new Button(shell, SWT.NONE);
		btn36.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(36);
			}
		});
		btn36.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn36.setBounds(407, 208, 60, 60);
		
		btn37 = new Button(shell, SWT.NONE);
		btn37.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(37);
			}
		});
		btn37.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn37.setBounds(473, 208, 60, 60);
		
		btn38 = new Button(shell, SWT.NONE);
		btn38.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(38);
			}
		});
		btn38.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn38.setBounds(539, 208, 60, 60);
		
		btn39 = new Button(shell, SWT.NONE);
		btn39.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(39);
			}
		});
		btn39.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn39.setBounds(605, 208, 60, 60);
		
		btn40 = new Button(shell, SWT.NONE);
		btn40.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(40);
			}
		});
		btn40.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn40.setBounds(11, 274, 60, 60);
		
		btn41 = new Button(shell, SWT.NONE);
		btn41.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(41);
			}
		});
		btn41.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn41.setBounds(77, 274, 60, 60);
		
		btn42 = new Button(shell, SWT.NONE);
		btn42.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(42);
			}
		});
		btn42.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn42.setBounds(143, 274, 60, 60);
		
		btn43 = new Button(shell, SWT.NONE);
		btn43.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(43);
			}
		});
		btn43.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn43.setBounds(209, 274, 60, 60);
		
		btn44 = new Button(shell, SWT.NONE);
		btn44.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(44);
			}
		});
		btn44.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn44.setBounds(275, 274, 60, 60);
		
		btn45 = new Button(shell, SWT.NONE);
		btn45.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(45);
			}
		});
		btn45.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn45.setBounds(341, 274, 60, 60);
		
		btn46 = new Button(shell, SWT.NONE);
		btn46.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(46);
			}
		});
		btn46.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn46.setBounds(407, 274, 60, 60);
		
		btn47 = new Button(shell, SWT.NONE);
		btn47.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(47);
			}
		});
		btn47.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn47.setBounds(473, 274, 60, 60);
		
		btn48 = new Button(shell, SWT.NONE);
		btn48.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(48);
			}
		});
		btn48.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn48.setBounds(539, 274, 60, 60);
		
		btn49 = new Button(shell, SWT.NONE);
		btn49.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(49);
			}
		});
		btn49.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn49.setBounds(605, 274, 60, 60);
		
		btn50 = new Button(shell, SWT.NONE);
		btn50.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(50);
			}
		});
		btn50.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn50.setBounds(11, 340, 60, 60);
		
		btn51 = new Button(shell, SWT.NONE);
		btn51.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(51);
			}
		});
		btn51.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn51.setBounds(77, 340, 60, 60);
		
		btn52 = new Button(shell, SWT.NONE);
		btn52.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(52);
			}
		});
		btn52.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn52.setBounds(143, 340, 60, 60);
		
		btn53 = new Button(shell, SWT.NONE);
		btn53.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(53);
			}
		});
		btn53.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn53.setBounds(209, 340, 60, 60);
		
		btn54 = new Button(shell, SWT.NONE);
		btn54.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(54);
			}
		});
		btn54.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn54.setBounds(275, 340, 60, 60);
		
		btn55 = new Button(shell, SWT.NONE);
		btn55.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(55);
			}
		});
		btn55.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn55.setBounds(341, 340, 60, 60);
		
		btn56 = new Button(shell, SWT.NONE);
		btn56.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(56);
			}
		});
		btn56.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn56.setBounds(407, 340, 60, 60);
		
		btn57 = new Button(shell, SWT.NONE);
		btn57.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(57);
			}
		});
		btn57.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn57.setBounds(473, 340, 60, 60);
		
		btn58 = new Button(shell, SWT.NONE);
		btn58.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(58);
			}
		});
		btn58.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn58.setBounds(539, 340, 60, 60);
		
		btn59 = new Button(shell, SWT.NONE);
		btn59.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(59);
			}
		});
		btn59.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn59.setBounds(605, 340, 60, 60);
		
		btn60 = new Button(shell, SWT.NONE);
		btn60.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(60);
			}
		});
		btn60.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn60.setBounds(11, 405, 60, 60);
		
		btn61 = new Button(shell, SWT.NONE);
		btn61.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(61);
			}
		});
		btn61.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn61.setBounds(77, 405, 60, 60);
		
		btn62 = new Button(shell, SWT.NONE);
		btn62.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(62);
			}
		});
		btn62.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn62.setBounds(143, 405, 60, 60);
		
		btn63 = new Button(shell, SWT.NONE);
		btn63.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(63);
			}
		});
		btn63.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn63.setBounds(209, 406, 60, 60);
		
		btn64 = new Button(shell, SWT.NONE);
		btn64.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(64);
			}
		});
		btn64.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn64.setBounds(275, 405, 60, 60);
		
		btn65 = new Button(shell, SWT.NONE);
		btn65.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(65);
			}
		});
		btn65.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn65.setBounds(341, 405, 60, 60);
		
		btn66 = new Button(shell, SWT.NONE);
		btn66.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(66);
			}
		});
		btn66.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn66.setBounds(407, 406, 60, 60);
		
		btn67 = new Button(shell, SWT.NONE);
		btn67.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(67);
			}
		});
		btn67.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn67.setBounds(473, 405, 60, 60);
		
		btn68 = new Button(shell, SWT.NONE);
		btn68.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(68);
			}
		});
		btn68.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn68.setBounds(539, 405, 60, 60);
		
		btn69 = new Button(shell, SWT.NONE);
		btn69.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(69);
			}
		});
		btn69.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn69.setBounds(605, 406, 60, 60);
		
		btn70 = new Button(shell, SWT.NONE);
		btn70.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(70);
			}
		});
		btn70.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn70.setBounds(11, 471, 60, 60);
		
		btn71 = new Button(shell, SWT.NONE);
		btn71.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(71);
			}
		});
		btn71.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn71.setBounds(77, 471, 60, 60);
		
		btn72 = new Button(shell, SWT.NONE);
		btn72.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(72);
			}
		});
		btn72.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn72.setBounds(143, 471, 60, 60);
		
		btn73 = new Button(shell, SWT.NONE);
		btn73.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(73);
			}
		});
		btn73.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn73.setBounds(209, 471, 60, 60);
		
		btn74 = new Button(shell, SWT.NONE);
		btn74.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(74);
			}
		});
		btn74.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn74.setBounds(275, 471, 60, 60);
		
		btn75 = new Button(shell, SWT.NONE);
		btn75.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(75);
			}
		});
		btn75.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn75.setBounds(341, 471, 60, 60);
		
		btn76 = new Button(shell, SWT.NONE);
		btn76.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(76);
			}
		});
		btn76.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn76.setBounds(407, 471, 60, 60);
		
		btn77 = new Button(shell, SWT.NONE);
		btn77.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(77);
			}
		});
		btn77.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn77.setBounds(473, 471, 60, 60);
		
		btn78 = new Button(shell, SWT.NONE);
		btn78.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(78);
			}
		});
		btn78.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn78.setBounds(539, 471, 60, 60);
		
		btn79 = new Button(shell, SWT.NONE);
		btn79.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(79);
			}
		});
		btn79.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn79.setBounds(605, 471, 60, 60);
		
		btn80 = new Button(shell, SWT.NONE);
		btn80.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(80);
			}
		});
		btn80.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn80.setBounds(11, 537, 60, 60);
		
		btn81 = new Button(shell, SWT.NONE);
		btn81.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(81);
			}
		});
		btn81.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn81.setBounds(77, 537, 60, 60);
		
		btn82 = new Button(shell, SWT.NONE);
		btn82.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(82);
			}
		});
		btn82.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn82.setBounds(143, 537, 60, 60);
		
		btn83 = new Button(shell, SWT.NONE);
		btn83.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(83);
			}
		});
		btn83.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn83.setBounds(209, 537, 60, 60);
		
		btn84 = new Button(shell, SWT.NONE);
		btn84.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(84);
			}
		});
		btn84.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn84.setBounds(275, 537, 60, 60);
		
		btn85 = new Button(shell, SWT.NONE);
		btn85.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(85);
			}
		});
		btn85.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn85.setBounds(341, 537, 60, 60);
		
		btn86 = new Button(shell, SWT.NONE);
		btn86.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(86);
			}
		});
		btn86.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn86.setBounds(407, 537, 60, 60);
		
		btn87 = new Button(shell, SWT.NONE);
		btn87.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(87);
			}
		});
		btn87.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn87.setBounds(473, 537, 60, 60);
		
		btn88 = new Button(shell, SWT.NONE);
		btn88.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(88);
			}
		});
		btn88.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn88.setBounds(539, 537, 60, 60);
		
		btn89 = new Button(shell, SWT.NONE);
		btn89.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(89);
			}
		});
		btn89.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn89.setBounds(605, 537, 60, 60);
		
		btn90 = new Button(shell, SWT.NONE);
		btn90.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(90);
			}
		});
		btn90.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn90.setBounds(11, 603, 60, 60);
		
		btn91 = new Button(shell, SWT.NONE);
		btn91.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(91);
			}
		});
		btn91.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn91.setBounds(77, 603, 60, 60);
		
		btn92 = new Button(shell, SWT.NONE);
		btn92.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(92);
			}
		});
		btn92.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn92.setBounds(143, 603, 60, 60);
		
		btn93 = new Button(shell, SWT.NONE);
		btn93.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(93);
			}
		});
		btn93.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn93.setBounds(209, 603, 60, 60);
		
		btn94 = new Button(shell, SWT.NONE);
		btn94.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(94);
			}
		});
		btn94.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn94.setBounds(275, 603, 60, 60);
		
		btn95 = new Button(shell, SWT.NONE);
		btn95.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(95);
			}
		});
		btn95.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn95.setBounds(341, 603, 60, 60);
		
		btn96 = new Button(shell, SWT.NONE);
		btn96.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(96);
			}
		});
		btn96.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn96.setBounds(407, 603, 60, 60);
		
		btn97 = new Button(shell, SWT.NONE);
		btn97.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(97);
			}
		});
		btn97.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn97.setBounds(473, 603, 60, 60);
		
		btn98 = new Button(shell, SWT.NONE);
		btn98.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(98);
			}
		});
		btn98.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn98.setBounds(539, 603, 60, 60);
		
		btn99 = new Button(shell, SWT.NONE);
		btn99.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clicked(99);
			}
		});
		btn99.setBackground(SWTResourceManager.getColor(124, 252, 0));
		btn99.setBounds(605, 603, 60, 60);
		
		btnMonsterCall = new Button(shell, SWT.NONE);
		btnMonsterCall.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				monsterCall();
			}
		});
		btnMonsterCall.setForeground(SWTResourceManager.getColor(255, 255, 255));
		btnMonsterCall.setFont(SWTResourceManager.getFont("Small Fonts", 16, SWT.BOLD));
		btnMonsterCall.setBackground(SWTResourceManager.getColor(135, 206, 235));
		btnMonsterCall.setBounds(706, 331, 307, 69);
		btnMonsterCall.setText("Monster Call");
		
		btnFireWeapon = new Button(shell, SWT.NONE);
		btnFireWeapon.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!hunter.fireWeapon) {
					btnFireWeapon.setBackground((SWTResourceManager.getColor(255, 0, 0)));
					btnFireWeapon.setText("Firing Weapon");					
				}
				else {
					btnFireWeapon.setBackground(SWTResourceManager.getColor(135, 206, 235));
					btnFireWeapon.setText("Not Firing");
				}
				hunter.fireWeapon = !hunter.fireWeapon;
			}
		});
		btnFireWeapon.setBackground(SWTResourceManager.getColor(135, 206, 235));
		btnFireWeapon.setForeground(SWTResourceManager.getColor(255, 255, 255));
		btnFireWeapon.setFont(SWTResourceManager.getFont("Small Fonts", 16, SWT.BOLD));
		btnFireWeapon.setText("Not Firing");
		btnFireWeapon.setBounds(706, 233, 307, 69);
		
		lblAmmo1 = new Label(shell, SWT.NONE);
		lblAmmo1.setImage(SWTResourceManager.getImage(MonsterHuntGame.class, "/Resources/shell.jpg"));
		lblAmmo1.setBounds(701, 31, 100, 174);
		
		lblAmmo2 = new Label(shell, SWT.NONE);
		lblAmmo2.setImage(SWTResourceManager.getImage(MonsterHuntGame.class, "/Resources/shell.jpg"));
		lblAmmo2.setBounds(807, 30, 100, 174);
		
		lblAmmo3 = new Label(shell, SWT.NONE);
		lblAmmo3.setImage(SWTResourceManager.getImage(MonsterHuntGame.class, "/Resources/shell.jpg"));
		lblAmmo3.setBounds(913, 30, 100, 174);
		
		txtHunterLocationIn = new Text(shell, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.MULTI);
		txtHunterLocationIn.setBackground(SWTResourceManager.getColor(240, 255, 255));
		txtHunterLocationIn.setFont(SWTResourceManager.getFont("Tahoma", 12, SWT.NORMAL));
		txtHunterLocationIn.setText("\r\nGOOD LUCK!");
		txtHunterLocationIn.setBounds(706, 429, 307, 234);
		
		for(Integer i : map.water) {
			updateColor(i, 0, 0, 255);
		}
		
		updateColor(hunter.location, 255, 255, 0);
	}
	
	private void updateColor(int location, int red, int blue, int green) {
		switch(location) {
			case 0: btn00.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 1: btn01.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 2: btn02.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 3: btn03.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 4: btn04.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 5: btn05.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 6: btn06.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 7: btn07.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 8: btn08.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 9: btn09.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 10: btn10.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 11: btn11.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 12: btn12.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 13: btn13.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 14: btn14.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 15: btn15.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 16: btn16.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 17: btn17.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 18: btn18.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 19: btn19.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 20: btn20.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 21: btn21.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 22: btn22.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 23: btn23.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 24: btn24.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 25: btn25.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 26: btn26.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 27: btn27.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 28: btn28.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 29: btn29.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 30: btn30.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 31: btn31.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 32: btn32.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 33: btn33.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 34: btn34.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 35: btn35.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 36: btn36.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 37: btn37.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 38: btn38.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 39: btn39.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 40: btn40.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 41: btn41.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 42: btn42.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 43: btn43.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 44: btn44.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 45: btn45.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 46: btn46.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 47: btn47.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 48: btn48.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 49: btn49.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 50: btn50.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 51: btn51.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 52: btn52.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 53: btn53.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 54: btn54.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 55: btn55.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 56: btn56.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 57: btn57.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 58: btn58.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 59: btn59.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 60: btn60.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 61: btn61.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 62: btn62.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 63: btn63.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 64: btn64.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 65: btn65.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 66: btn66.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 67: btn67.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 68: btn68.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 69: btn69.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 70: btn70.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 71: btn71.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 72: btn72.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 73: btn73.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 74: btn74.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 75: btn75.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 76: btn76.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 77: btn77.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 78: btn78.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 79: btn79.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 80: btn80.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 81: btn81.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 82: btn82.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 83: btn83.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 84: btn84.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 85: btn85.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 86: btn86.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 87: btn87.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 88: btn88.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 89: btn89.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 90: btn90.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 91: btn91.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 92: btn92.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 93: btn93.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 94: btn94.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 95: btn95.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 96: btn96.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 97: btn97.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 98: btn98.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
			case 99: btn99.setBackground(SWTResourceManager.getColor(red, blue, green)); break;
		}	
	}
	
	private void clicked(int btn) {
		while(!locate.isEmpty()) {
			if (locate.peek().equals(hunter.location)) locate.pop();
			else updateColor(locate.pop(), 124, 252, 0);
		}
		if (gameOver) restartGame();
		else if (map.water.contains(btn)) txtHunterLocationIn.setText("\r\nCANNOT MOVE THROUGH WATER.");		
		else if (map.paths[hunter.location].distTo(btn) > 3) txtHunterLocationIn.setText("\r\nCANNOT MOVE MORE THAN 3 SPACES.");
		else {
			updateColor(hunter.location, 124, 252, 0 );
			hunter.location = btn;
			updateColor(hunter.location, 255, 255, 0);
			if (hunter.fireWeapon) {
				hunter.ammo--;
				switch(hunter.ammo) {
					case 2 : lblAmmo1.setImage(SWTResourceManager.getImage(MonsterHuntGame.class, "/Resources/empty.jpg")); break;
					case 1 : lblAmmo2.setImage(SWTResourceManager.getImage(MonsterHuntGame.class, "/Resources/empty.jpg")); break;
					case 0 : lblAmmo3.setImage(SWTResourceManager.getImage(MonsterHuntGame.class, "/Resources/empty.jpg"));
				}
				if (closeShot()) {
					txtHunterLocationIn.setText("\r\nCONGRATULATIONS!! YOU KILLED THE MONSTER!\r\n\r\n\r\nCLICK ANY LOCATION TO RESTART.");
					gameOver = true;					
				}
				else if (hunter.ammo == 0) {
					txtHunterLocationIn.setText("YOUR SHOT MISSED THE MONSTER AND NOW YOU ARE OUT OF AMMO. BETTER GO HOME TO REST AND RELOAD.  \r\n\r\nGAME OVER\r\n\r\n CLICK ANY LOCATION TO RESTART.");
					gameOver = true;
				}
				else {
					txtHunterLocationIn.setText("\r\nYOU MOVED TO SPACE " + hunter.location + " AND FIRED A SHOT.  \r\nUNFORTUNATELY YOU MISSED THE MONSTER.");
					monster.moveMonster(map.mapGraph);
					fadeTracks();
					showTracks();
				}
			}
			else {
				if (hunter.location == monster.location) {
					txtHunterLocationIn.setText("\r\nYOU FOUND THE MONSTER, BUT DIDN'T FIRE A SHOT. YOU WERE EATEN BY THE MONSTER.\r\n\r\nGAME OVER.\r\n\r\nCLICK ANY LOCATION TO RESTART.");
					gameOver = true;
				}
				else {
					monster.moveMonster(map.mapGraph);
					txtHunterLocationIn.setText("\r\nYOU MOVED TO SPACE " + hunter.location + ", NO MONSTER HERE.");
					fadeTracks();
					showTracks();
				}
			}
		}		
	}
	
	//highlight area near monster location
	private void monsterCall() {
		while(!locate.isEmpty()) {
			if (locate.peek().equals(hunter.location)) locate.pop();
			else updateColor(locate.pop(), 124, 252, 0);
		}
		updateColor(monster.location, 255, 0, 0);
		locate.push(monster.location);
		for(int i : map.mapGraph.adj(monster.location)) {
			updateColor(i, 255, 0, 0);
			locate.push(i);
		}
		monster.moveMonster(map.mapGraph);
		updateColor(hunter.location, 255, 255, 0);
		if (monster.location == hunter.location) {
			gameOver = true;
			txtHunterLocationIn.setText("\r\nYOU WERE EATEN BY THE MONSTER.\r\n\r\nGAME OVER.\r\n\r\nCLICK ANY LOCATION TO RESTART.");
		}
	}
	
	//resets the game
	private void restartGame() {
		map = new Map(in);
		hunter.location = 0;
		monster = new Monster();
		hunter.ammo = 3;
		lblAmmo1.setImage(SWTResourceManager.getImage(MonsterHuntGame.class, "/Resources/shell.jpg"));
		lblAmmo2.setImage(SWTResourceManager.getImage(MonsterHuntGame.class, "/Resources/shell.jpg"));
		lblAmmo3.setImage(SWTResourceManager.getImage(MonsterHuntGame.class, "/Resources/shell.jpg"));		
		for (int i = 0; i < 100; i++) updateColor(i, 124, 252, 0);
		for(Integer i : map.water) updateColor(i, 0, 0, 255);
		updateColor(hunter.location, 255, 255, 0);
		hunter.fireWeapon = false;
		btnFireWeapon.setBackground(SWTResourceManager.getColor(135, 206, 235));
		gameOver = false;
	}
	
	//changes previously located tracks as they fade
	private void fadeTracks() {
		if (!monster.foundTracks.isEmpty()) {
			for (Integer i : monster.foundTracks.dequeue()) updateColor(i, 124, 252, 0);
			int k = 0;
			for (Queue<Integer> q : monster.foundTracks) {
				if (k == 0) {
					for (Integer i : q) updateColor(i, 194, 178, 128);
					k++;
				}
				else for (Integer i : q) updateColor(i, 152, 133, 88);
			}
		}
	}
	
	//Shows tracks if the hunter is next to a track
	private void showTracks() {
		boolean foundTracks = false;
		ArrayList<Integer> adj = new ArrayList<Integer>();
		adj.add(hunter.location);
		for (Integer i : map.mapGraph.adj(hunter.location)) adj.add(i);
		for (Queue<Integer> q : monster.tracks) {
			for (Integer i : q) {
				if (adj.contains(i)) foundTracks = true;
			}
		}
		if (foundTracks) {
			int age = 0;
			while(!monster.foundTracks.isEmpty()) {
				for (int i : monster.foundTracks.dequeue()) updateColor(i, 124, 252, 0);				
			}
			for (Queue<Integer> q : monster.tracks) {
				switch(age) {
					case 0 : {
						for (Integer i : q) updateColor(i, 194, 178, 128);
						break;
					}
					case 1 : {
						for (Integer i : q) updateColor(i, 152, 133, 88);
						break;
					}
					default : {
						for (Integer i : q) updateColor(i, 92, 64, 51);
					}
				}
				monster.foundTracks.enqueue(q);
				age++;
			}
			updateColor(hunter.location, 255, 255, 0);
		}
	}
	
	//determines if the hunter is close enough to kill the monster.
	private boolean closeShot() {
		boolean temp = false;
		if (monster.location == hunter.location) temp = true;
		for (Integer i : map.mapGraph.adj(hunter.location)) {
			if (i == monster.location) temp = true;
		}
		return temp;
	}
	
	
}

	

//package edu.buffalostate.cis425.sp17.exercises.marron;
/**
 File: ColorPicker.java
 Exercise 19 - ColorPicker
 Programmer: Jeffrey Marron
 Date Created:  2.5.2017
 Last Modified: 2.5.2017


   Description: This app illustrates the use of the
   java.awt.Color class. It lets the user type red, green and
   blue (RGB) values into text fields, and displays the resulting
   color both as a font color and as a colored rectangle.
   This version of ColorPicker uses programmer defined IntFields
   which throw an out-of-range exception if the values input are
   not between 0 and 255. The only changes required occur in the
   declarations for the IntFields, in the init() method where the
   IntFields are instantiated, and in the actionPerformed() method
   the the getInt() method is used to retrieve their data.


  Assignment:  1) Run this program to see how it works
               2) Modify this program so that it uses JSliders to
                  select the range of colors. Arrange the JSliders
                  so they are oriented horizontally and stacked using
                  a grid layout:

                 |-------- slider1 ----------|
                 |-------- slider2 ----------|
                 |-------- slider3 ----------|

               - See the example in the SliderExample folder to get started
 */

import javax.swing.JSlider;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class ColorPicker extends JFrame implements ChangeListener{
    private JSlider redIn = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);//sliders
    private JSlider greenIn = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
    private JSlider blueIn = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);

    private JLabel R = new JLabel("R:"),
            G = new JLabel("G:"),
            B = new JLabel("B:");
    private JPanel controls = new JPanel();
    private Canvas canvas = new Canvas();

    /**
     *  init() sets up the app's interface. A (default) border layout
     *   is used, with the controls at the north and the drawing canvas
     *   in the center.
     */
    public ColorPicker() {
        initControls();
        getContentPane().add(controls, "North");
        getContentPane().add(canvas, "Center");
        canvas.setBorder(BorderFactory.createTitledBorder("The Color Display"));
        getContentPane().setBackground(Color.white);
        setSize(250,250);
        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );
    }

    /**
     *  initControls() arranges the app's control components in a separate
     *   JPanel, which is placed at the north border. The controls consist of
     *   three JTextFields into which the user can type RGB values.
     */
    private void initControls() {

        redIn.addChangeListener(this);//change listeners
        greenIn.addChangeListener(this);
        blueIn.addChangeListener(this);

        controls.setLayout( new GridLayout(3, 1));//new gridlayout
        controls.setBorder(BorderFactory.createTitledBorder("Set values for RGB"));
        controls.add(R);
        controls.add(redIn);     // Add prompts and textfields
        controls.add(G);
        controls.add(greenIn);
        controls.add(B);
        controls.add(blueIn);

    } //END initControls()

    /**stateChanged() - does not require out of range checking or intField because sliders values are finite.
     * sets the values for each slider by using getValue.  then sets the rgb color to the canvas and calls repaint */
    public void stateChanged( ChangeEvent e) {
    		int r, g, b;//temp ints
    		r=redIn.getValue();//gets value from the redIn slider
            b=blueIn.getValue();
            g=greenIn.getValue();
            canvas.setColor(new Color(r, g, b));//sends the current color values to the canvas
            repaint();//updates output
    }//END stateChanged

    /** main */
    public static void main(String args[]) {
        ColorPicker c = new ColorPicker();
        c.setVisible(true);
    } //END main()

} //END ColorPicker


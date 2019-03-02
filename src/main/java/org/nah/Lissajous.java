package org.nah;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.Collections;
import java.util.ArrayList;
import java.io.BufferedReader;

/**
 * @author naharrison
 */
public class Lissajous extends PApplet {

  public static void main(String[] args) {
    PApplet.main("org.nah.Lissajous");
  }


  public int frRate, r1, r2, margin, dotsize;
  public double w1, phi1, w2, phi2;
  ArrayList<Float> xpoints;
  ArrayList<Float> ypoints;


  public void settings() {
    size(700, 700);
  }


  public void setup() {
    frRate = 30;
    frameRate(frRate);

    r1 = 35;
    w1 = 1.5*2.2;
    phi1 = Math.PI/4;

    r2 = 125;
    w2 = 1.5*0.4;
    phi2 = 0.0;

    margin = 10;
    dotsize = 7;
    xpoints = new ArrayList<>();
    ypoints = new ArrayList<>();
  }


  public void draw() {
    background(255);

    noFill();
    ellipse(r1+margin, height/2, 2*r1, 2*r1);
    fill(0);
    float x1 = (float) (r1+margin+r1*Math.cos(w1*frameCount/frRate + phi1));
    float y1 = (float) (height/2 - r1*Math.sin(w1*frameCount/frRate + phi1));
    ellipse(x1, y1, dotsize, dotsize);

    noFill();
    ellipse(width/2, r2+margin, 2*r2, 2*r2);
    fill(0);
    float x2 = (float) (width/2 + r2*Math.cos(w2*frameCount/frRate + phi2));
    float y2 = (float) (r2+margin-r2*Math.sin(w2*frameCount/frRate + phi2));
    ellipse(x2, y2, dotsize, dotsize);

    line(x1, y1, x2, y1);
    line(x2, y2, x2, y1);

    xpoints.add(x2);
    ypoints.add(y1);
    for(int k = 0; k < xpoints.size(); k++) {
      ellipse(xpoints.get(k), ypoints.get(k), dotsize/2, dotsize/2);
    }

    if(xpoints.size() > 1500) {
      xpoints.clear();
      ypoints.clear();
    }
  }

}

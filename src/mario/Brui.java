package mario;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import org.omg.CORBA.portable.InputStream;
	/*
 	* Fichier qui permet de produire du son.
 	* Constructeur :Nom du fichier 
 	*/

public class Brui {
	private AudioClip clip ;
	
	String chemin = "";
	
	private File f ;
	
	private boolean bool ;
	
   
	
	public Brui(String s , boolean bool){		
		this.chemin=s ;
		this.bool = bool ;
		
	}
	
	
	
	
	
	public boolean getBool() {
		return bool;
	}

	public void setBool(boolean bool) {
		this.bool = bool;
	}

	public void jou(){
		//clip.play() ;
		f = new File(chemin+".wav");
		try {
			if(bool){
				
			 AudioInputStream stream;
			 AudioFormat format;
			 DataLine.Info info;
			 Clip clip;			
		

		    stream = AudioSystem.getAudioInputStream(f);
		    format = stream.getFormat();
		    info = new DataLine.Info(Clip.class, format);
		    clip = (Clip) AudioSystem.getLine(info);
		    clip.open(stream);
		    clip.start();
			} 
		}
		catch (Exception e) {
			System.out.println("ouch");
		}
	}

	
	public void lop(){
		
		
		try {
			f = new File(chemin+".wav");
			
			if(bool){
			
				clip = Applet.newAudioClip(f.toURL());
				clip.loop() ;
			}
		}catch (MalformedURLException e){
			System.out.println(e.getMessage());
		}
	}
	
	public void stop(){
		if(clip != null)
			clip.stop() ;
	}

	public AudioClip getClip() {
		return clip;
	}

	public void setClip(AudioClip clip) {
		this.clip = clip;
	}
	

	public File getF() {
		return f;
	}

	public void setF(File f) {
		this.f = f;
	}
	
}

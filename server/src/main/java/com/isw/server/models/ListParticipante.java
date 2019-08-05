package com.isw.server.models;

import java.util.ArrayList;

public class ListParticipante {
    private ArrayList<String> names;
    private ArrayList<String> mails;

	public ListParticipante(){
		this.names = new ArrayList<String>();
		this.mails = new ArrayList<String>();
	}
	
	public ArrayList<String> getNames() {
		return this.names;
	}

	public void setNames(ArrayList<String> names) {
		this.names = names;
	}

	public ArrayList<String> getMails() {
		return this.mails;
	}

	public void setMails(ArrayList<String> mails) {
		this.mails = mails;
	}
} 
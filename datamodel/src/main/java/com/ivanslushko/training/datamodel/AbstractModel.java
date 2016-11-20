package com.ivanslushko.training.datamodel;

import java.io.Serializable;

public class AbstractModel implements Serializable{
	
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
    public static String table() {
        return "";
    }
    public String getTable() {
        String className = this.getClass().getSimpleName();
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";

        return className.replaceAll(regex, replacement).toLowerCase();
//      toLowerCase()
//      replace
//      Синтаксис   str.replace(regexp, newSubStr|function)
//      Этот метод не меняет вызывающую строку, а возвращает новую, после замен.        
    }
}

package com.ivanslushko.training.datamodel;

public class AbstractModel {
	
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
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public String getTable() {
        String className = this.getClass().getSimpleName();
        String regex = "([a-z])([A-Z]+)";
        String replacement = "$1_$2";

        return className.replaceAll(regex, replacement).toLowerCase();
    }
    
    
//    replace
//
//    Синтаксис
//
//    str.replace(regexp, newSubStr|function)
//    Аргументы
//
//    regexp
//    объект типа RegExp или строка
//    newSubStr|function
//    новая подстрока или функция, которая ее возвращает
//    Описание, примеры
//
//    Этот метод не меняет вызывающую строку, а возвращает новую, после замен.
    
    
//	String	toLowerCase()
//	Converts all of the characters in 
//	this String to lower case using the rules of the d
//	efault locale.
	
	
//	public class Example
//	{
//	   public static void Main()
//	   {
//	      string pattern =  @"(\p{Sc}\s?)?(\d+\.?((?<=\.)\d+)?)(?(1)|\s?\p{Sc})?";
//	      string input = "$17.43  €2 16.33  £0.98  0.43   £43   12€  17";
//	      string replacement = "$2";
//	      Regex rgx = new Regex(pattern);
//	      string result = rgx.Replace(input, replacement);
//
//	      Console.WriteLine("Original String:    '{0}'", input);
//	      Console.WriteLine("Replacement String: '{0}'", result);                             
//	   }
//	}
	// The example displays the following output:
//	       Original String:    '$17.43  €2 16.33  £0.98  0.43   £43   12€  17'
//	       Replacement String: '17.43  2 16.33  0.98  0.43   43   12  17'
	
}

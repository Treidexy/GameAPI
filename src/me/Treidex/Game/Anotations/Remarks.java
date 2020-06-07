package me.Treidex.Game.Anotations;

public @interface Remarks {
	String Author() default "";
	String ProjectName() default "";
	String[] Links() default "";
	String Description() default "";
	String Version() default "r1.0";
}
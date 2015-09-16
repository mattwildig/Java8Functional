package designPatterns.strategy;

import java.util.List;

//This is in fact a functional interface, so it means we can 
//use a lambda to implement it...
interface Formatter{
	String format(List<String> unformattedString);
}
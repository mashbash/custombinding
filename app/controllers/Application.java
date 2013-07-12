package controllers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import models.Issue;
import models.IssueTag;
import models.Tag;
import play.data.binding.As;
import play.mvc.Controller;
import binders.CommaSeperatedValueBinder;

public class Application extends Controller {


    public static void index(@As(binder=CommaSeperatedValueBinder.class) String[] tags) {
//    	Issue issue = new Issue();
//    	issue.setTags(new HashSet(Arrays.asList(tags)));
        render("@index", tags);
    }
    
    public static void addTags(@As(binder=CommaSeperatedValueBinder.class) String[] tags) {
    	Issue issue = new Issue();
    	issue.setTags(tags);
    	for (String tag : tags) {
			new IssueTag(issue, Tag.findOrCreateByName(tag));
		}
   
    }
    	
}


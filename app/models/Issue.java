package models;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.apache.commons.lang.StringUtils;

import play.db.jpa.Model;

@Entity
public class Issue extends Model{

	@OneToMany(mappedBy = "issue", cascade=CascadeType.ALL)
	Set<IssueTag> issueTags;
	
	private String tags;

	public Set<String> getTags() {
	    return new HashSet(Arrays.asList(tags.split("\\s*,\\s*")));
	}

	public void setTags(String[] tags) {
//	    String[] arr = tags.toArray(new String[0]);
	    this.tags = StringUtils.join(tags, ", ");
	    this.save();
	}
	
	//TODO: check to make sure that the issue doesn't already exist, add another method
	//this feature needed in app

}

package models;

import java.util.Set;

import javax.persistence.*;

import play.db.jpa.Model;

@Entity
public class Tag extends Model{

//  we don't want to set this relationship because later we will want to tag Tasks as well so it gives flexibility
//	@OneToMany(mappedBy = "tag", cascade=CascadeType.ALL)
//	Set<IssueTag> issueTags;
	
	public String name;
//	public String issueOrTask;
	
	public Tag(String name){
		this.name = name;
	}
		
	public static Tag findOrCreateByName(String name) {
		Tag tag = Tag.find("byName", name).first();
		if (tag == null) {
			tag = new Tag(name);
			tag.save();
		}
		return tag;
	}
	
	

}

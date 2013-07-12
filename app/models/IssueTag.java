package models;

import javax.persistence.*;

import play.db.jpa.Model;

@Entity
@Table(name = "ISSUE_TAGS")
public class IssueTag extends Model{
	
	@ManyToOne
	public Issue issue;
	
	@ManyToOne
	public Tag tag;
	
	public IssueTag(Issue issue, Tag tag) {
		this.issue = issue;
		this.tag = tag;
		this.save();
	}
	
	public static IssueTag findOrCreate(Issue issue, Tag tag) {
		IssueTag issueTag = IssueTag.find("issue = ? and tag = ?", issue, tag).first();
		if(issueTag == null) {
			new IssueTag(issue, tag);
		}
		return issueTag;
	}

	

}

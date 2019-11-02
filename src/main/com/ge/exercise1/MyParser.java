package com.ge.exercise1;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;

public class MyParser implements Parser {

	@Override
	public Application parseApplicationData(String data) {

		Collection<Group> groupList = new ArrayList<>();
		
		String[]  output= data.split("\\[", 0);
		String[] application = StringUtils.substringsBetween(output[0],":", ",");
		String[] users = StringUtils.substringsBetween(output[1],":",",");
		String[] groups = StringUtils.substringsBetween(output[2], ":", ",");
		
		UserData userData = new UserData(users[0].trim(),StringUtils.substringBetween(users[1],"",")").trim());
		Group groupData = new GroupData(groups[0].trim(), groups[1].trim());
		groupList.add(groupData);
		groupData.size= groupList.size();
		
		Application app = new Application(application[0], application[1]) {
			
			@Override
			public Collection<User> getUsers() {
				 Collection<User> userList = new ArrayList<>();
				 userList.add(userData);
				return userList;
			}
			
			@Override
			public User getUser(String userId) {
				if(userData.getId().equals(userId))
				{
					return userData;
				}
				else
				{
					return null;
				}
				

			}
			
			@Override
			public Collection<Group> getGroups() {
				return groupList;
			}
			
			@Override
			public Group getGroup(String groupId) {
				if(groupData.getId().equals(groupId))
				{
					return groupData;
				}
				else
				{
					return null;
				}
			}
		};
		
		return app;
	}

	
}

package com.dto;

public class DeleteEmployee {
	private String UserName;
	private String Emailid;
	private String ContactNumber;
   
    private String password; 
   
    
   public String getUserName() {
    return UserName;
    }
   
    public void setUserName(String UserName) {
   	 this.UserName=UserName;
    }
      
        public String getEmailid() {
            return Emailid;
            }
        
            public void setEmailid(String Emailid) {
           	 this.Emailid=Emailid;
            }
            
            public String getContactNumber() {
                return ContactNumber;
                }
            
                public void setContactNumber(String ContactNumber) {
               	 this.ContactNumber=ContactNumber;
                }
                
                
						public String getPassword() {
							return password;
						}

						public void setPassword(String password) {
							this.password = password;
						}

						

						
}

package security;

import org.apache.shiro.authc.AuthenticationInfo;

import java.util.HashSet;
import java.util.Set;

import javax.management.relation.Role;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;

import model.User;

public class AppRealm extends JdbcRealm{
	
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException{
		
		UsernamePasswordToken userPassToken=(UsernamePasswordToken) token;
		final String email=userPassToken.getUsername();
		
		final User user = User.getUser(email);
		if (user==null) {
			System.out.println("No account found for user with email"+ email);
			return null;
		}
		return new SimpleAuthenticationInfo(user.getUser_id(),user.get_password(),getName());
		}
	
	protected AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
		Set<String> roles=new HashSet<>();
		if(principals.isEmpty()) {
			System.out.println("Given principals to authorize are empty.");
			return null;
		}
		
		String email=(String) principals.getPrimaryPrincipal();
		final User user=User.getUser(email);
		
		if(user==null) {
			System.out.println("No account found for user with email"+email);
			return null;
		}
		
		if (user.get_user_type()==0) {
			roles.add(AppSession.CUSTOMER_ROLE);
		}else if (user.get_user_type()==1) {
			
			roles.add(AppSession.EXPERT_ROLE);
			
		}
		
		return new SimpleAuthorizationInfo(roles);
		
		
		
		
	}

}

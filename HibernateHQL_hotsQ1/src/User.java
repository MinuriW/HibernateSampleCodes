import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="\"user\"")
public class User implements Serializable {
    @Id
	@Column
	@SequenceGenerator(name="my_user_seq", sequenceName="user_seq", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="my_user_seq")
	private int userid;
    @Column(name="authenticate")
    private int authenticate;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;

	public User() {
		super();
	}
	
	public User(int authenticate, int userid, String username, String password, String name, String email) {
		super();
		this.authenticate = authenticate;
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public int getAuthenticate() {
		return authenticate;
	}

	public void setAuthenticate(int authenticate) {
		this.authenticate = authenticate;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

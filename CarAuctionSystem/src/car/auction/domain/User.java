package car.auction.domain;

public class User {
    private int id;
    private String username;
    private String password;
    
    public User (int id, String username, String password) {
    	this.setId(id);
    	this.setUsername(username);
    	this.setPassword(password);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
    
    public static User getUser(int userId) {
//        UserFinder finder = new UserFinder();
//        UserGateway record = finder.findUserById(userId);
        User result = null;
//        if (record != null) {
//            if (record instanceof CustomerGateway) {
//                // TODO we don't initialise orders and cart for now
//                result = new Customer(record.getId(), record.getEmail(),
//                        record.getName(), ((CustomerGateway) record).getAddress(), new LinkedList<>(), new ShoppingCart());
//            } else if (record instanceof AuthorGateway) {
//                result = new Author(record.getId(), record.getEmail(), record.getName(),
//                        ((AuthorGateway) record).getBiography());
//            }
//        }
        
        return result;
    }
}

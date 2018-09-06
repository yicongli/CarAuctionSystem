package car.auction.domain;

import java.util.ArrayList;
import java.util.List;

public class History {
	private int id;
	private Long date;
	private String operationType;
	private int operatorID;
	private String updatedField;	// the field of car that has been updated
	private String updatedContent;	// the content of updated field
	
	public History(int id, Long date, String operationType, int operatorID, 
			String updatedField, String updatedContent) {
		this.setId(id);
		this.setDate(date);
		this.setOperationType(operationType);
		this.setOperatorID(operatorID);
		this.setUpdatedField(updatedContent);
		this.setUpdatedContent(updatedContent);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public int getOperatorID() {
		return operatorID;
	}

	public void setOperatorID(int operatorID) {
		this.operatorID = operatorID;
	}

	public String getUpdatedField() {
		return updatedField;
	}

	public void setUpdatedField(String updatedField) {
		this.updatedField = updatedField;
	}

	public String getUpdatedContent() {
		return updatedContent;
	}

	public void setUpdatedContent(String updatedContent) {
		this.updatedContent = updatedContent;
	}
	
    public static List<History> getAllAvailableHistory() {
//        BookFinder finder = new BookFinder();
        List<History> result = new ArrayList<History>();
//        List<BookGateway> booksRecords = finder.findAvailableBooks();
//
//        for (BookGateway br : booksRecords) {
//            Book book = new Book(String.valueOf(br.getIsbn()), br.getAuthor(), br.getTitle(),
//                    br.getPrice(), br.getCopies());
//            result.add(book);
//        }
        return result;
    }
}

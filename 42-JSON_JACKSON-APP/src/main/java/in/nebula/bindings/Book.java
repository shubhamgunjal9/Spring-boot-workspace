package in.nebula.bindings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	
	private Integer bookId;
	
	private String bookName;
	
	private Double bookPrice;
	

}

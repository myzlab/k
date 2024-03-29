package ve.zlab.k.test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import ve.zlab.k.annotations.Column;
import ve.zlab.k.annotations.Id;
import ve.zlab.k.annotations.KClass;
import ve.zlab.k.model.KModelDTO;
import ve.zlab.k.annotations.KTable;

@Getter
@NoArgsConstructor
@KTable(name = "my_customer", alias = "mc")
@KClass(entityClass = MyCustomerDTO.class, columnIdClass = Long.class)
public class MyCustomerDTO extends KModelDTO {

    public final static String ID = "id";
    public final static String NAME = "name";
    public final static String LAST_NAME = "last_name";
    
    @Id(name = ID)
    @Column(name = ID)
    private Long id;
    
    @Column(name = NAME)
    private String name;
    
    @Column(name = LAST_NAME)
    private String lastName;

    public MyCustomerDTO setName(String name) {
        this.name = name;
        this.addFieldToUpdate(NAME);
        
        return this;
    }

    public MyCustomerDTO setLastName(String lastName) {
        this.lastName = lastName;
        this.addFieldToUpdate(LAST_NAME);
        
        return this;
    }

    public MyCustomerDTO setId(Long id) {
        this.id = id;
        this.addFieldToUpdate(ID);
        
        return this;
    }
    
    //    @Join(name = "Book")
//    public JoinData joinBook() {
//        //"my_book_example b", "b.my_customer_example_id", "f.id"
//        
////        return clazz.newInstance();
////        return 
//        return new JoinData(MyBookExample.class, "A", "b");
//    }
    
    @Override
    public String getNameColumnId() {
        return ID;
    }
}

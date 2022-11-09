package gdsc.spring3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class BankTeller {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 30)
    private String tellerName;

    @Column(nullable = false, length = 30)
    private String tellerPhoneNum;

    @Column(nullable = false, length = 30)
    private String tellerPosition; // 은행원 직위

    @OneToMany(mappedBy = "customerName")
    private List<Customer> customers = new ArrayList<>();



}

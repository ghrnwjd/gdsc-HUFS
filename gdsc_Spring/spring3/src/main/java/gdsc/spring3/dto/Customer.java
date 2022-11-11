package gdsc.spring3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 30)
    private String customerName;

    @Column(nullable = false, length = 30)
    private String customerPhoneNum;

    @Column(nullable = false, length = 30)
    private int customer_use_year; // 은행 이용한 기간

    @Column(nullable = false, length = 20)
    private List<String> service_bankteller;

    public void setService_bankteller(String service_bankteller) {
        this.service_bankteller.add(service_bankteller);
    }
}

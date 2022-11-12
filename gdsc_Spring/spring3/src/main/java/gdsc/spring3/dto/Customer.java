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

    public void setService_bankteller(boolean flag, String service_bankteller) {
        if (flag)
            this.service_bankteller.add(service_bankteller);
        else {
            int index = this.service_bankteller.indexOf(service_bankteller);
            List<String> new_list = null;
            for (int i = 0; i < this.service_bankteller.size(); i++) {
                if(i != index)
                    new_list.add(this.service_bankteller.get(i));
            }
            this.service_bankteller = new_list;
        }
    }
}

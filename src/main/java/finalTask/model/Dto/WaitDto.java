package finalTask.model.Dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class WaitDto {
    private int waitNum;
    private String phone;
    private int memberNum;
}

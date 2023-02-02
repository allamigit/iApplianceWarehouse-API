package e_appliance_warehouse.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "general_config")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class GeneralConfig extends CommonColumns {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "config_id")
	private Long configId;
	
	@Column(name= "company_location_code", nullable = false, unique = true)
	private String companyLocationCode;
	
	@Column(name= "company_name")
	private String companyName;
	
	@Column(name= "company_address")
	private String companyAddress;
	
	@Column(name= "company_city")
	private String companyCity;
	
	@Column(name= "company_state")
	private String companyState;
	
	@Column(name= "company_zip")
	private String companyZip;
	
	@Column(name= "company_phone", unique = true)
	private String companyPhone;
	
	@Column(name= "company_email")
	private String companyEmail;
	
	@Column(name= "company_website")
	private String companyWebsite;
	
	@Column(name = "sales_tax_percent", nullable = false)
	private Double salesTaxPercent;

	@Column(name = "min_stock_item_qty", nullable = false)
	private Integer minStockItemQTY;

}

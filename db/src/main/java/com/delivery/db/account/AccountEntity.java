package com.delivery.db.account;


import com.delivery.db.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Entity
@Table(name = "account")
@Data
@EqualsAndHashCode(callSuper = true)
public class AccountEntity extends BaseEntity {
}

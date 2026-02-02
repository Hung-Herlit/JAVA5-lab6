package lab.lab6.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Entity
@Table(name = "categories")
@NamedQueries({
    @NamedQuery(name = "Category.findAllCategiries", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.countCategories", query = "SELECT COUNT(c) FROM Category c")
})
public class Category {

    @Id
    @Column(name = "id", length = 20)
    private String id;
    @Column(name = "name", columnDefinition = "nvarchar(50)", nullable = false)
    private String name;
}
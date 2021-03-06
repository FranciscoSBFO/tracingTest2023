package com.example.tracingtest2023.model.operacion.metodos.fra20rter.datas;

import com.example.tracingtest2023.model.operacion.metodos.fra20rter.FRA_RTER_001;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class FRA_RTER_001_DATA_02 {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long idFRARTERDATA02;

    //Valores definidos para "TD"
    private String medicion;
    private String e1;
    private String e2;
    private String e3;
    private String promedioEspesor;
    private String fuerzaFluenciaTension;
    private String elongacionRuptura;
    private String resistenciaTension;
    private String pendiente;
    private String coeficienteCorrelacionPearson;
    private String moduloElastico;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idfrarter")
    private FRA_RTER_001 fra_rter_001;
}

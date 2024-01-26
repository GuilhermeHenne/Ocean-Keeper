public class Carta {
    private String pergunta;
    private int poluicaoImpacto;
    private int biodiversidadeImpacto;
    private int mudancasClimaticasImpacto;
    private int pescaImpacto;
    private int orcamentoImpacto;
    
    public Carta(String pergunta, int poluicaoImpacto, int biodiversidadeImpacto, int mudancasClimaticasImpacto, int pescaImpacto, int orcamentoImpacto) {
        this.pergunta = pergunta;
        this.poluicaoImpacto = poluicaoImpacto;
        this.biodiversidadeImpacto = biodiversidadeImpacto;
        this.mudancasClimaticasImpacto = mudancasClimaticasImpacto;
        this.pescaImpacto = pescaImpacto;
        this.orcamentoImpacto = orcamentoImpacto;
    }
    
    public String getPergunta() {
        return pergunta;
    }
    
    public int getPoluicaoImpacto() {
        return poluicaoImpacto;
    }
    
    public int getBiodiversidadeImpacto() {
        return biodiversidadeImpacto;
    }
    
    public int getMudancasClimaticasImpacto() {
        return mudancasClimaticasImpacto;
    }
    
    public int getPescaImpacto() {
        return pescaImpacto;
    }
    
    public int getOrcamentoImpacto() {
        return orcamentoImpacto;
    }
}

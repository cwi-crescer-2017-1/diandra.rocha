namespace LocadoraCrescer.Dominio.Entidades
{
    public class ReservaOpcional
    {
        public int Id { get; private set; }
        public Opcional Opcional  { get; private set; }
        public Reserva Reserva { get; private set; }
        public int QuantidadeOpcionais { get; private set; }

        protected ReservaOpcional()
        {

        }

    }
}

namespace EditoraCrescer.Infraestrutura.Entidades
{
    public class Autor
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }

        public Autor(string nome)
        {
            Nome = nome;
        }
    }
}
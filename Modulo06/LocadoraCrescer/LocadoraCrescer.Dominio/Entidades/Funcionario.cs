using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;

namespace LocadoraCrescer.Dominio.Entidades
{
    public class Funcionario
    {
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public string Email { get; private set; }
        public string Senha { get; private set; }
        public List<Permissao> Permissoes { get; private set; }

        protected Funcionario()
        {

        }

        public Funcionario(string nome, string email, string senha, string [] permissoes)
        {
            Nome = nome;
            Email = email;
            if (!string.IsNullOrWhiteSpace(senha))
                Senha = CriptografarSenha(senha);
            AtribuirPermissoes(permissoes);
        }

        public void AtribuirPermissoes(string[] nomes)
        {
            Permissoes = new List<Permissao>();
            foreach (var nome in nomes)
                Permissoes.Add(new Permissao(nome));
        }

        private string CriptografarSenha(string senha)
        {
            MD5 md5 = MD5.Create();
            byte[] inputBytes = Encoding.Default.GetBytes(Email + senha);
            byte[] hash = md5.ComputeHash(inputBytes);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < hash.Length; i++)
                sb.Append(hash[i].ToString("x2"));

            return sb.ToString();
        }

        public bool ValidarSenha(string senha)
        {
            return CriptografarSenha(senha) == Senha;
        }
    }
}

from googletrans import Translator
from textblob import TextBlob
import sys
import io

def translate_to_english(text):
    translator = Translator()
    translation = translator.translate(text, src='pt', dest='en')
    return translation.text

def analise_sentimentos(texto):
    texto_traduzido = translate_to_english(texto)

    blob = TextBlob(texto_traduzido)

    # Analisar o sentimento
    sentimento = blob.sentiment

    # Interpretar o sentimento
    polaridade = sentimento.polarity
    subjetividade = sentimento.subjectivity

    # Determinar a interpretação do sentimento
    if polaridade > 0:
        if polaridade >= 0.5:
            resultadoPolaridade = " e expressa um sentimento muito positivo."
        else:
            resultadoPolaridade = " e expressa um sentimento positivo moderado."
    elif polaridade < 0:
        if polaridade <= -0.5:
            resultadoPolaridade = " e expressa um sentimento muito negativo."
        else:
            resultadoPolaridade = " e expressa um sentimento negativo moderado."
    else:
        resultadoPolaridade = " e neutro."

    if subjetividade >= 0.75:
        resultadoSubjetividade = "Altamente subjetivo"
    elif subjetividade >= 0.5:
        resultadoSubjetividade = "Subjetivo"
    else:
        resultadoSubjetividade = "Objetivo"

    return "Texto em pt-br: " + texto + "\nTexto em en: " + texto_traduzido + "\nResultado: " + resultadoSubjetividade + resultadoPolaridade

if __name__ == "__main__":
    # Para garantir que a entrada use UTF-8
    sys.stdin = io.TextIOWrapper(sys.stdin.buffer, encoding='utf-8')
    texto = sys.stdin.read()
    resultado = analise_sentimentos(texto)
    print(resultado)

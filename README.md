# Automação de Testes Mobile com Appium e JUnit

Este projeto é uma automação de testes mobile utilizando **Appium** como ferramenta de automação e **JUnit** como framework de testes. A aplicação alvo é identificada pelo pacote `net.nuvem.mobile.carguero.release`.

## 📋 **Pré-requisitos**

Certifique-se de que os seguintes softwares estão instalados no ambiente:

1. **JDK (Java Development Kit)** - Versão 8 ou superior.
2. **Appium Server** - Versão 2.13.1 ou superior.
3. **Node.js** - Necessário para o Appium Server.
4. **Android SDK** - Para emulação e comunicação com dispositivos Android.
5. **Dispositivo Android ou Emulador** - Certifique-se de que o dispositivo esteja configurado para depuração USB e seja detectado pelo `adb`.
6. **Maven** - Para gerenciar as dependências do projeto.

---

## ⚙️ **Configuração do Ambiente**

**Instalando dependências:**

1. Instale o Appium Server
   ```bash
   npm install -g appium
   ```
2. Instale os drivers necessários (ex: uiautomator2):
   ```bash
   appium driver install uiautomator2
   ```

3. Configure o Android SDK:
* Certifique-se de que o comando adb funcione no terminal:
   ```bash
   adb devices
   ```


## 🚀  **Execução da Automação**

**Passos para execução:**

1. Inicie o Appium Server: Certifique-se de que o Appium está rodando na porta padrão (4723):
   ```bash
   appium
   ```

2. Configure o dispositivo/emulador: Verifique se o dispositivo/emulador está conectado:
   ```bash
   adb devices
   ```
   O dispositivo deve aparecer na lista como device.


3. Compile e execute os testes: Use o Maven para compilar e executar os testes:
   ```bash
   mvn test
   ```
  Os resultados serão gerados no diretório allure-results.

4. Geração de Relatórios Allure

Baixe e instale o Allure CLI:

- [Download do Allure CLI.](https://allurereport.org/docs/install/)
- Adicione o binário do Allure ao PATH.

```bash
allure serve allure-results
```
Isso abrirá automaticamente o relatório no navegador.

## 🛠️  **Configuração de Testes**

**BaseTest**

A classe BaseTest configura o driver Appium, utilizando AndroidDriver, *essas informações devem ser alteradas na properties*. O setup inclui configurações como:

* **platformName**: Nome da plataforma (Android).
* **automationName**: UiAutomator2 para interações com dispositivos Android.
* **appPackage**: Pacote do aplicativo alvo.
* **appActivity**: Atividade principal do aplicativo.

   ```bash
   @BeforeEach
   public void setUp() throws MalformedURLException {
       DesiredCapabilities capabilities = new DesiredCapabilities();
       capabilities.setCapability("platformName", "Android");
       capabilities.setCapability("deviceName", "YOUR_DEVICE_OU_EMULATOR");
       capabilities.setCapability("appPackage", "net.nuvem.mobile.carguero.release");
       capabilities.setCapability("appActivity", "net.nuvem.mobile.carguero.StartActivity");
       capabilities.setCapability("noReset", true);
       driver = new AndroidDriver(new URL("http://localhost:4723/"), capabilities);
   }

   ```

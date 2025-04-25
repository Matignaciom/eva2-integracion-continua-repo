pipeline {
    agent any
    
    tools {
        // Definir la instalación de Maven a utilizar
        maven 'M3'
        jdk 'JDK'
    }
    
    stages {
        stage('Preparación') {
            steps {
                // Limpieza del workspace
                echo 'Limpiando y preparando el entorno...'
                bat 'mvn clean'
            }
        }
        
        stage('Build') {
            steps {
                echo 'Compilando el proyecto...'
                bat 'mvn compile'
            }
            post {
                success {
                    echo 'Compilación exitosa!'
                }
                failure {
                    echo 'Error en la compilación del proyecto'
                }
            }
        }
        
        stage('Testing') {
            steps {
                echo 'Ejecutando pruebas...'
                
                // Ejecutar todas las pruebas
                bat 'mvn test'
                
                // Mostrar resultados específicos de los casos de prueba
                echo 'Resultados de los casos de prueba específicos:'
                echo 'Caso 1: Ingresar nombre de usuario y contraseña correctos - testAutenticacionValida'
                echo 'Caso 2: Ingresar nombre de usuario y contraseña incorrectos - testAutenticacionInvalida'
                echo 'Caso 3: Ingresar valores vacíos - testAutenticacionValoresVacios'
            }
            post {
                success {
                    echo 'Todas las pruebas pasaron correctamente!'
                }
                failure {
                    echo 'Algunas pruebas fallaron'
                }
            }
        }
        
        stage('Empaquetado') {
            steps {
                echo 'Empaquetando la aplicación...'
                bat 'mvn package -DskipTests'
            }
            post {
                success {
                    echo 'Aplicación empaquetada correctamente'
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                }
            }
        }
    }
    
    post {
        always {
            echo 'Pipeline completado'
            // Publicar resultados de pruebas JUnit
            junit '**/target/surefire-reports/*.xml'
        }
        success {
            echo 'Pipeline ejecutado exitosamente'
        }
        failure {
            echo 'El pipeline ha fallado'
        }
    }
}
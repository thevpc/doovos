20090304
TODO
optimisation du code généré par JITSRC
    -1- si des opérations peuvent se faire sur la boot VM autant le faire
        En effet une op de type push suivi de pop qui est en JIT dans la même classe n'as pas besoin de la stack de Doovos
    -2- Ne pas générer de fichier java mais directement une classe
    -3- après le passage d'une op imposant un initializeClass refaire un JIT qui puisse remplacer cette op en sachant
        qu'elle n'appellera plus initializeClass et donc peut être inlinée avec les op suivantes

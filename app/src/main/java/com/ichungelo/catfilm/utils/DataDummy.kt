package com.ichungelo.catfilm.utils

import com.ichungelo.catfilm.R
import com.ichungelo.catfilm.data.DataEntity

object DataDummy {
    //butuh di update dengan spek sama seperti movie, tvShow, detail Entity
    fun generateDataMovies(): List<DataEntity> {
        val allDataMovies = ArrayList<DataEntity>()

        allDataMovies.add(
            DataEntity(
                "m1",
                "A Star Is Born",
                2018,
                "R",
                "Drama, Romance",
                "",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                R.drawable.poster_a_start_is_born.toString()
            )
        )

        allDataMovies.add(
            DataEntity(
                "m2",
                "Alita: Battle Angel",
                2019,
                "PG-13",
                "Action, Science Fiction, Adventure",
                "An angel falls. A warrior rises.",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                R.drawable.poster_alita.toString()
            )
        )

        allDataMovies.add(
            DataEntity(
                "m3",
                "Aquaman",
                2018,
                "PG-13",
                "Action, Adventure, Fantasy",
                "Home Is Calling",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                R.drawable.poster_aquaman.toString()
            )
        )

        allDataMovies.add(
            DataEntity(
                "m4",
                "Bohemian Rhapsody",
                2018,
                "PG-13",
                "Music, Drama, History",
                "Fearless lives forever",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                R.drawable.poster_bohemian.toString()
            )
        )

        allDataMovies.add(
            DataEntity(
                "m5",
                "Cold Pursuit",
                2019,
                "R",
                "Action, Crime, Thriller",
                "Meet Nels Coxman. Citizen of the Year.",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                R.drawable.poster_cold_persuit.toString()
            )
        )

        allDataMovies.add(
            DataEntity(
                "m6",
                "Creed II",
                2018,
                "PG-13",
                "Drama",
                "There's More to Lose than a Title",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                R.drawable.poster_creed.toString()
            )
        )

        allDataMovies.add(
            DataEntity(
                "m7",
                "Fantastic Beasts: The Crimes of Grindelwald",
                2018,
                "PG-13",
                "Adventure, Fantasy, Drama",
                "Fate of One. Future of All.",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                R.drawable.poster_crimes.toString()
            )
        )

        allDataMovies.add(
            DataEntity(
                "m8",
                "Glass",
                2019,
                "PG-13",
                "Thriller, Drama, Science Fiction",
                "You Cannot Contain What You Are",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                R.drawable.poster_glass.toString()
            )
        )

        allDataMovies.add(
            DataEntity(
                "m9",
                "How to Train Your Dragon: The Hidden World",
                2019,
                "SU",
                "Animation, Family, Adventure",
                "The friendship of a lifetime",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                R.drawable.poster_how_to_train.toString()
            )
        )

        allDataMovies.add(
            DataEntity(
                "m10",
                "Avengers: Infinity War",
                2018,
                "PG-13",
                "Adventure, Action, Science Fiction",
                "An entire universe. Once and for all.",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                R.drawable.poster_infinity_war.toString()
            )
        )


        allDataMovies.add(
            DataEntity(
                "m11",
                "Mary Queen of Scots",
                2018,
                "R",
                "Drama, History",
                "Bow to No One",
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
                R.drawable.poster_marry_queen.toString()
            )
        )

        allDataMovies.add(
            DataEntity(
                "m12",
                "Master Z: Ip Man Legacy",
                2018,
                "PG-13",
                "Action",
                "",
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                R.drawable.poster_master_z.toString()
            )
        )

        allDataMovies.add(
            DataEntity(
                "m13",
                "Mortal Engines",
                2018,
                "PG-13",
                "Advenbture, Science Fiction",
                "Some scars never heal",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                R.drawable.poster_mortal_engines.toString()
            )
        )

        allDataMovies.add(
            DataEntity(
                "m14",
                "Overlord",
                2018,
                "R",
                "Horror, War, Science Fiction",
                "Stop the unstoppable",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                R.drawable.poster_overlord.toString()
            )
        )

        allDataMovies.add(
            DataEntity(
                "m15",
                "Ralph Beraks the Internet",
                2018,
                "PG",
                "Family, Animation, Comedy, Adventure",
                "Who Broke the Internet?",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
                R.drawable.poster_ralph.toString()
            )
        )

        allDataMovies.add(
            DataEntity(
                "m16",
                "Robin Hood",
                2018,
                "PG-13",
                "Adventure, Action, Thriller",
                "The legend you know. The story you don't",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                R.drawable.poster_robin_hood.toString()
            )
        )

        allDataMovies.add(
            DataEntity(
                "m17",
                "Serenity",
                2019,
                "R",
                "Thriller, Mystery, Drama",
                "On Plymouth Island, no one ever dies… unless you break the rules",
                "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
                R.drawable.poster_serenity.toString()
            )
        )

        allDataMovies.add(
            DataEntity(
                "m18",
                "Spider-Man: Into the Spider-Verse",
                2018,
                "PG",
                "Action, Adventure, Animation, Science Fiction, Comedy",
                "More than one wears the mask.",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                R.drawable.poster_spiderman.toString()
            )
        )

        allDataMovies.add(
            DataEntity(
                "m19",
                "T-34",
                2018,
                "12+",
                "War, Action, Drama, History",
                "Fast And Furious On Tanks",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
                R.drawable.poster_t_three_four.toString()
            )
        )

        return allDataMovies
    }

    fun generateDataTvShows(): List<DataEntity> {
        val allDataTvShows = ArrayList<DataEntity>()

        allDataTvShows.add(
            DataEntity(
                "t1",
                "Arrow",
                2012,
                "TV-14",
                "Crime, Drama, Mystery, Action & Adventure",
                "Heroes fall, Legends rise.",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                R.drawable.poster_arrow.toString()
            )
        )

        allDataTvShows.add(
            DataEntity(
                "t2",
                "Doom Patrol",
                2019,
                "TV-MA",
                "Sci-Fi & Fantasy, Drama",
                "",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                R.drawable.poster_doom_patrol.toString()
            )
        )

        allDataTvShows.add(
            DataEntity(
                "t3",
                "Dragon Ball",
                1986,
                "TV-PG",
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                "",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                R.drawable.poster_dragon_ball.toString()
            )
        )

        allDataTvShows.add(
            DataEntity(
                "t4",
                "Fairy Tail",
                2009,
                "TV-14",
                "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy, Mystery",
                "",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                R.drawable.poster_fairytail.toString()
            )
        )

        allDataTvShows.add(
            DataEntity(
                "t5",
                "Family GUy",
                1999,
                "TV-14",
                "Animation, Comedy",
                "Parental Discretion Advised, that's how you know it's good",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                R.drawable.poster_family_guy.toString()
            )
        )

        allDataTvShows.add(
            DataEntity(
                "t6",
                "The Flash",
                2014,
                "TV-14",
                "Drama, Sci-Fi & Fantasy",
                "The fastest man alive.",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                R.drawable.poster_flash.toString()
            )
        )

        allDataTvShows.add(
            DataEntity(
                "t7",
                "Game of Thrones",
                2011,
                "TV-MA",
                "Sci-Fi & Fantasy, Drama, Action & Adventure",
                "Winter Is Coming",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                R.drawable.poster_god.toString()
            )
        )

        allDataTvShows.add(
            DataEntity(
                "t8",
                "Gotham",
                2014,
                "TV-14",
                "Drama, Crime, Sci-Fi & Fantasy",
                "Before Batman, there was Gotham.",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                R.drawable.poster_gotham.toString()
            )
        )

        allDataTvShows.add(
            DataEntity(
                "t9",
                "Grey's Anatomy",
                2005,
                "TV-14",
                "Drama",
                "The life you save may be your own.",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                R.drawable.poster_grey_anatomy.toString()
            )
        )

        allDataTvShows.add(
            DataEntity(
                "t10",
                "Hanna",
                2019,
                "TV-MA",
                "Action & Adventure, Drama",
                "",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                R.drawable.poster_hanna.toString()
            )
        )

        allDataTvShows.add(
            DataEntity(
                "t11",
                "Marvel's Iron Fist",
                2017,
                "TV-MA",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                R.drawable.poster_iron_fist.toString()
            )
        )

        allDataTvShows.add(
            DataEntity(
                "t12",
                "Naruto Shippūden",
                2007,
                "TV-PG",
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                "",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                R.drawable.poster_naruto_shipudden.toString()
            )
        )

        allDataTvShows.add(
            DataEntity(
                "t13",
                "NCIS",
                2003,
                "TV-14",
                "Crime, Action & Adventure, Drama",
                "",
                "From murder and espionage to terrorism and stolen submarines, a team of special agents investigates any crime that has a shred of evidence connected to Navy and Marine Corps personnel, regardless of rank or position.",
                R.drawable.poster_ncis.toString()
            )
        )

        allDataTvShows.add(
            DataEntity(
                "t14",
                "Riverdale",
                2017,
                "TV-14",
                "Mystery, Drama, Crime",
                "Small town. Big secrets.",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                R.drawable.poster_riverdale.toString()
            )
        )

        allDataTvShows.add(
            DataEntity(
                "t15",
                "Shameless",
                2011,
                "TV-MA",
                "Drama, Comedy",
                "The Gallaghers. Absolutely, Wildly, Unapologetically... Shameless",
                "Chicagoan Frank Gallagher is the proud single dad of six smart, industrious, independent kids, who without him would be... perhaps better off. When Frank's not at the bar spending what little money they have, he's passed out on the floor. But the kids have found ways to grow up in spite of him. They may not be like any family you know, but they make no apologies for being exactly who they are.",
                R.drawable.poster_shameless.toString()
            )
        )

        allDataTvShows.add(
            DataEntity(
                "t16",
                "Supergirl",
                2015,
                "TV-14",
                "Drama, Sci-Fi & Fantasy, Action & Adventure",
                "Better. Stronger. Together.",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                R.drawable.poster_supergirl.toString()
            )
        )

        allDataTvShows.add(
            DataEntity(
                "t17",
                "Supernatural",
                2005,
                "TV-14",
                "Drama, Mystery, Sci-Fi & Fantasy",
                "Between darkness and deliverance",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                R.drawable.poster_supernatural.toString()
            )
        )

        allDataTvShows.add(
            DataEntity(
                "t18",
                "The Simpson",
                1989,
                "TV-PG",
                "Family, Animation, Comedy",
                "On your marks, get set, d'oh!",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                R.drawable.poster_the_simpson.toString()
            )
        )

        allDataTvShows.add(
            DataEntity(
                "t19",
                "The Umbrella Academy",
                2019,
                "TV-MA",
                "Action & Adventure, Sci-Fi & Fantasy, Drama",
                "Super. Dysfunctional. Family.",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                R.drawable.poster_the_umbrella.toString()
            )
        )

        allDataTvShows.add(
            DataEntity(
                "t20",
                "The Walking Dead",
                2010,
                "TV-MA",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "Fight the dead. Fear the living.",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                R.drawable.poster_the_walking_dead.toString()
            )
        )

        return allDataTvShows
    }
}
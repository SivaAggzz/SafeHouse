    Task:

    Create a SINGLE SCREEN App which fetches data from an open web service -
    The Breaking Bad Api. Data required to be fetched is a single api which contains
    all the information of the actors/characters in the series.

    You can find the web service here.
    Base URL - https://www.breakingbadapi.com/api/
    the only endpoint you'd need for the characters data mentioned above - /api/characters

    Requirements:
            1. MVVM - maintain fetching and storage logic in a ViewModel (1st priority)

2. UI requirements (2nd priority)
    - The single screen will contain a grid of items where each item is each actor's
     large portrait image. So, the app when launched displays a scrollable grid with
     at least 2 items horizontally arranged.
            - Whenever the user long presses the image item in the grid,
            The Character's name and the actor's name appears in a short
             duration toast.
            (Try to keep the text in white or with a dark background also,
             so that it's visible over the images)



            3. use of Coil library for image processing (preferred but still Optional)

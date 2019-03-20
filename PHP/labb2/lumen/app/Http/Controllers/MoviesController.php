<?php



/* Vi fick våran inspiration ifrån Fredriks föreläsningar och kodexempel. */




// Väljer namespace
 namespace App\Http\Controllers;

// Använder klassen Movie och funktionalitet ifrån Request
 use Illuminate\Http\Request;
 use App\Movie;

 class MoviesController extends Controller
 {
   // Hämtar lista och sorterar efter titel
   public function index()
   {
     $movie_query = Movie::query();

     $movie_query -> orderBy( 'title' );

     $movies = $movie_query -> get();
     return $movies;
   }

   // Hämtar en specifik film med id
   public function read($id)
   {
      $movie = Movie::findOrFail($id);
      return $movie;
   }

   // Skapar en film

     /**
      * @param Request $request
      * @return array
      * @throws \Illuminate\Validation\ValidationException
      */
     public function create(Request $request)
   {
     $data = $this -> validate($request, [
       'title' => 'required|string',
       'year' => 'integer',
       'genre' => 'string',
       'rating' => 'integer|min:1|max:10',
   ]);

   // Fyller i data och sparar
   $movie = new Movie();
   $movie -> fill($data);
   $movie -> save();

  return
  [
      'success' => true,
      // Sätter ett id
      'id' => $movie -> id
  ];

   }

   // Uppdaterar datan på specifik film

     /**
      * @param Request $request
      * @param $id
      * @return array
      * @throws \Illuminate\Validation\ValidationException
      */

     public function update(Request $request, $id)
   {
     $data = $this -> validate($request, [
       'title' => 'filled|string',
       'year' => 'integer',
       'genre' => 'string',
       'rating' => 'integer|min:1|max:10'
     ]);

     // Letar upp filmen, fyller i data och sparar
     $movie = Movie::findOrFail($id);
     $movie -> fill($data);
     $movie -> save();

     return
     [
       'success' => true,
     ];
   }

   // Raderar specifik film
   public function delete($id)
   {
     // Letar upp specifik film och raderar
     $movie = Movie::findOrFail($id);
     $movie -> delete($id);

     return
     [
       'success' => true,
     ];
   }
 }

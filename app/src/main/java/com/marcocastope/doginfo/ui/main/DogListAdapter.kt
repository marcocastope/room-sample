package com.marcocastope.doginfo.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.marcocastope.doginfo.R
import com.marcocastope.doginfo.data.model.Dog
import com.squareup.picasso.Picasso


class DogListAdapter(private val dogs: MutableList<Dog> = mutableListOf(), private val listener: (Dog) -> Unit)
    : RecyclerView.Adapter<DogListAdapter.DogViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_dog_main, parent, false)
        return DogViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.bind(dogs[position])
        holder.itemView.setOnClickListener { listener(dogs[position]) }
    }

    override fun getItemCount(): Int = dogs.size

    fun setDogs(dogs: List<Dog>) {
        this.dogs.clear()
        this.dogs.addAll(dogs)
        notifyDataSetChanged()
    }

    class DogViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val dogBreed = view.findViewById<TextView>(R.id.dogBreed)
        private val dogDescription = view.findViewById<TextView>(R.id.dogDescription)
        private val dogImage = view.findViewById<ImageView>(R.id.dogImage)

        fun bind(dog: Dog) {
            dogBreed.text = dog.breed
            dogDescription.text = dog.description
            if (dog.posterPath != null && dog.posterPath.isNotEmpty()) {
                Picasso.get().load(dog.posterPath).into(dogImage)
            } else {
                dogImage.setImageDrawable(ResourcesCompat.getDrawable(itemView.resources, R.drawable.ic_baseline_pets, null))
            }
        }
    }
}